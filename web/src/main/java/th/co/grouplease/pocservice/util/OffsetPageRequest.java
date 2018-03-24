package th.co.grouplease.pocservice.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author: Peeranut Ngaorungsri (peeranut.ng@grouplease.co.th) on 17/01/2018.
 */
public class OffsetPageRequest implements Pageable, Serializable {

  private final Sort sort;
  private int limit;
  private long offset;

  private OffsetPageRequest(long offset, int limit, Sort sort) {
    if (offset < 0) {
      throw new IllegalArgumentException("Offset index must not be less than zero!");
    }

    if (limit < 1) {
      throw new IllegalArgumentException("Limit must not be less than one!");
    }
    this.limit = limit;
    this.offset = offset;
    this.sort = sort;
  }

  private OffsetPageRequest(long offset, int limit, Sort.Direction direction, String... properties) {
    this(offset, limit, new Sort(direction, properties));
  }

  public static OffsetPageRequest of(long offset, int limit){
    return new OffsetPageRequest(offset, limit, Sort.unsorted());
  }

  public static OffsetPageRequest of(long offset, int limit, Sort sort){
    return new OffsetPageRequest(offset, limit, sort);
  }

  public static OffsetPageRequest of(long offset, int limit, Sort.Direction direction, String... properties){
    return new OffsetPageRequest(offset, limit, direction, properties);
  }

  @Override
  public int getPageNumber() {
    return (int) (offset / limit);
  }

  @Override
  public int getPageSize() {
    return limit;
  }

  @Override
  public long getOffset() {
    return offset;
  }

  @Override
  public Sort getSort() {
    return sort;
  }

  @Override
  public Pageable next() {
    return new OffsetPageRequest(getOffset() + getPageSize(), getPageSize(), getSort());
  }

  public OffsetPageRequest previous() {
    return hasPrevious() ? new OffsetPageRequest(getOffset() - getPageSize(), getPageSize(),
        getSort()) : this;
  }

  @Override
  public Pageable previousOrFirst() {
    return hasPrevious() ? previous() : first();
  }

  @Override
  public Pageable first() {
    return new OffsetPageRequest(0, getPageSize(), getSort());
  }

  @Override
  public boolean hasPrevious() {
    return offset > limit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof OffsetPageRequest)) return false;

    OffsetPageRequest that = (OffsetPageRequest) o;

    return new EqualsBuilder()
        .append(limit, that.limit)
        .append(offset, that.offset)
        .append(sort, that.sort)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(limit)
        .append(offset)
        .append(sort)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("limit", limit)
        .append("offset", offset)
        .append("sort", sort)
        .toString();
  }
}