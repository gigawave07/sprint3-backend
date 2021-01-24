package com.sprint3.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.sprint3.backend.entity.CheckThesis;
import com.sprint3.backend.entity.Student;
import com.sprint3.backend.entity.Thesis;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.SubscribeThesisService;

@Configuration
@EnableScheduling
public class AutoSendMailForStudent {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SubscribeThesisService subscribeThesisService;

    @Autowired
    private StudentRepository studentRepository;

    @Bean
    public TaskScheduler taskScheduler() {
        final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }

    @Scheduled(fixedDelay = 1000 * 3600 * 24)
    private void scheduleFixedDelayTask() {
        System.out.println("System auto send mail start.");
        List<CheckThesis> allCheckThesis = this.subscribeThesisService.findAllCheckThesisForMail();
        List<CheckThesis> listCheckThesisNearExpired = new ArrayList<>();
        if (!allCheckThesis.isEmpty()) {
            filterCheckThesis(allCheckThesis, listCheckThesisNearExpired);
        } else {
            System.out.println("List check thesis is empty.");
        }
    }

    private void filterCheckThesis(List<CheckThesis> allCheckThesis, List<CheckThesis> listCheckThesisNearExpired) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime checkDate;
        for (CheckThesis checkThesis : allCheckThesis) {
            for (int i = 1; i <= 4; i++) {
                if (checkThesis.getCheckDate() != null) {
                    checkDate = checkThesis.getCheckDate().plusDays(7 * i);
                    Duration between = Duration.between(now, checkDate);
                    System.out.println(between.toHours());
                    if (between.toHours() > 24) {
                        break;
                    }
                    if (between.toHours() > 0) {
                        listCheckThesisNearExpired.add(checkThesis);
                        break;
                    }
                } else break;
            }
        }
        try {
            sendMail(listCheckThesisNearExpired);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMail(List<CheckThesis> listCheckThesisNearExpired) throws InterruptedException {
        List<Student> studentListBeEmailed = new ArrayList<>();
        try {
            for (CheckThesis checkThesis : listCheckThesisNearExpired) {
                Thesis thesis = checkThesis.getThesis();
                filterStudent(studentListBeEmailed, checkThesis);
                for (Student student : studentListBeEmailed) {
                    createMail(student, thesis);
                }
            }
        } catch (RuntimeException runtimeException) {
            Thread.sleep(300000);
            scheduleFixedDelayTask();
        }
        System.out.println("Complete");
    }

    private void filterStudent(List<Student> studentListBeEmailed, CheckThesis checkThesis) {
        Long idStudentGroup = checkThesis.getStudentGroup().getId();
        List<Student> allStudents = this.studentRepository.findAll();
        for (Student student : allStudents) {
            if (student.getStudentGroup().getId().equals(idStudentGroup)) {
                studentListBeEmailed.add(student);
            }
        }
    }

    private void createMail(Student student, Thesis thesis) {
        try {
            MimeMessage message = this.emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            String nameStudent = student.getFullName();

            helper.setTo(student.getEmail());
            System.out.println(student.getEmail());
            helper.setSubject("Thông báo cập nhật tiến độ luận văn");

            String mailContent = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "   <title>Mail</title>\n" +
                    "    <link rel=\"stylesheet\" " +
                    "href=\"https://fonts.googleapis.com/css?family=Roboto|Varela+Round\">\n" +
                    "    <link rel=\"stylesheet\" " +
                    "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n" +
                    "    <link rel=\"stylesheet\" " +
                    "href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                    "    <style>\n" +
                    "        * {\n" +
                    "            font-family: \"Varela Round\";\n" +
                    "        }\n" +
                    "\n" +
                    "        .bodyMail {\n" +
                    "            margin-top: 1%;\n" +
                    "        }\n" +
                    "\n" +
                    "        h5 {\n" +
                    "            color: white;\n" +
                    "            background-color: #007bff;\n" +
                    "            text-align: center\n" +
                    "        }\n" +
                    "\n" +
                    "        p {\n" +
                    "            margin: 1% 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        table {\n" +
                    "            border: 1px solid;\n" +
                    "            border-collapse: separate;\n" +
                    "            width: 100%\n" +
                    "        }\n" +
                    "\n" +
                    "        td, th {\n" +
                    "            border: 1px solid;\n" +
                    "            text-align: center;\n" +
                    "        }\n" +
                    "\n" +
                    "        span {\n" +
                    "            color: blue;\n" +
                    "        }\n" +
                    "\n" +
                    "        .autoMail {\n" +
                    "            color: red;\n" +
                    "        }\n" +
                    "\n" +
                    "        img {\n" +
                    "            width: 100%;\n" +
                    "            height: 300px;\n" +
                    "        }\n" +
                    "    </style>" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"container-fluid\">\n" +
                    "  <div class=\"row\">\n" +
                    "    <div class=\"col-sm-3\"></div>\n" +
                    "    <div class=\"col-sm-6 bodyMail\">\n" +
                    "    <div>\n" +
                    "      <p>Thân gửi sinh viên: <span>" + nameStudent + "</span></p>\n" +
                    "      <p>Sắp đến hạn cập nhật nội dung đề tài tốt nghiệp để giáo viên kiểm tra.\n" +
                    "                Đề nghị bạn thực hiện đúng tiến độ.</p>\n" +
                    "            <p>Thông tin tiến độ của bạn : </p>\n" +
                    "\n" +
                    "            <div class=\"row\">\n" +
                    "                <div class=\"container-xl\">\n" +
                    "                    <div class=\"table-responsive\">\n" +
                    "                        <div class=\"table-wrapper\">\n" +
                    "                            <table>\n" +
                    "                                <tr>\n" +
                    "                                    <th>Tên đề tài</th>\n" +
                    "                                    <th>Nội dung đề tài</th>\n" +
                    "                                    <th>Giáo viên hướng dẫn</th>\n" +
                    "                                    <th>Ngày cập nhật tiến độ</th>\n" +
                    "                                </tr>" + "<tr>\n" +
                    "<td>" +
                    thesis.getStatement() +
                    "</td>" +
                    "<td>" +
                    thesis.getDescription() +
                    "</td>" +
                    "<td>" +
                    thesis.getTeacher().getFullName() +
                    "</td>" +
                    "<td>" +
                    LocalDateTime.now().plusDays(1)
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                    "</td>" +
                    "</tr>" +
                    "</table>\n" +
                    "            </div>\n" +
                    "          </div>\n" +
                    "        </div>\n" +
                    "      </div>\n" +
                    "      <p class=\"autoMail\">P/s : Đây là hệ thống thông báo tự động. " +
                    "Bạn không cần trả lời thư này!</p>\n" +
                    "<img src=\"https://nhanlucnganhluat.vn/uploads/images/CC5D2D3D/logo/2019-11/" +
                    "68d6e0fa-42d1-11e8-9485-56c566ee3692.png\">\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"col-sm-3\"></div>\n" +
                    "</div>\n" +
                    "</div>" +
                    "</body>\n" +
                    "</html>\n";
            helper.setText(mailContent, true);
            this.emailSender.send(message);
        } catch (MessagingException messaging) {
            messaging.getStackTrace();
        }
    }
}
