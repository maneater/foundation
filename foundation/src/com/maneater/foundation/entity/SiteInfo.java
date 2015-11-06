package com.maneater.foundation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SiteInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
