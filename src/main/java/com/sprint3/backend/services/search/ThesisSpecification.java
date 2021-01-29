package com.sprint3.backend.services.search;




import com.sprint3.backend.entity.Thesis;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ThesisSpecification implements Specification<Thesis> {

    private final SearchCriteria criteria;

    public ThesisSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Thesis> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase("like")) {
            // value like %chuỗi_tìm_kiếm%
            return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValues().get(0) + "%");
        } else if (criteria.getOperation().equalsIgnoreCase("equal")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValues().get(0));
        } else {
            return null;
        }
    }
}
