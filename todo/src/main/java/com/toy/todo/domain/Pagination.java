package com.toy.todo.domain;

import lombok.Data;

/* [페이징]

- 페이지 헬퍼 라이브러리를 의존성으로 주입 받아 쓰고
  있어서 없어도 되지만, 게시글을 10개씩 끊어서 관리하기
  위해 작성한 코드

 1. 페이지 필수 정보
  - 페이지 번호 : page
  - 페이지당 게시글 수 : size
  - 노출 페이지 개수 : count
  - 전체 데이터 개수 : total

 2. 페이지 수식 정보
 - 시작 번호 : start
 - 끝 번호 : end
 - 첫 번호 : first
 - 마지막 번호 : last
 - 이전 번호 : prev
 - 다음 번호 : next
 - 데이터 순서 번호 : index
*/

/* @Data 어노테이션 (역할 & 사용목적)
  - Getter / Setter: 모든 필드에 대한 getter와 setter 생성
  - toString(): 객체 상태를 문자열로 표현하는 메서드 생성
  - equals() / hashCode(): 객체 비교를 위한 메서드 생성
  - RequiredArgsConstructor: final 또는 @NonNull 필드를 위한 생성자 생성
*/

@Data
public class Pagination {
    // 페이징 기본값
    private static final long PAGE_NUM = 1; // 현재 페이지 번호 기본값
    private static final long SIZES = 10; // 페이지당 게시글 수 기본값
    private static final long COUNT = 10; // 노출 페이지 개수 기본값

    // 필수 정보
    private long page;
    private long size;
    private long count;
    private long total;

    // 수식 정보
    private long start;
    private long end;
    private long first;
    private long last;
    private long prev;
    private long next;
    private long index;

    // 생성자
    public Pagination() {
        this(0);
    }

    // 데이터 개수
    public Pagination(long total) {
        this(PAGE_NUM, total);
    }

    // 현재 번호, 데이터 개수
    public Pagination(long page, long total) {
        this(page, SIZES, COUNT, total);
    }

    // 필수 정보
    public Pagination(long page, long size, long count, long total) {
        this.page = page;
        this.size = size;
        this.count = count;
        this.total = total;
        calc();
    }

    // setter
    /* 데이터 개수를 지정한 후,
       페이지 수식을 재계산 처리
       하는 메서드
    */
    public void setTotal(long total) {
        this.total = total;
        calc();
    }

    // 페이징 처리 수식
    public void calc() {
        // 첫번째 번호
        this.first = 1;

        // 마지막 번호
        this.last = (this.total - 1) / size + 1;

        // 시작 번호
        this.start = ( (page - 1 ) / count ) * count + 1;

        // 끝 번호
        this.end = ( (page - 1) / count + 1 ) * count;
        if(this.end > this.last) this.end = this.last;

        // 이전 번호
        this.prev = this.page - 1;

        // 다음 번호
        this.next = this.page + 1;

        // 데이터 순서 번호
        this.index = (this.page - 1) * this.size;
    }
}