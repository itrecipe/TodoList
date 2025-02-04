DROP TABLE IF EXISTS todos;

create table todos (
no BIGSERIAL PRIMARY KEY, -- PK로 BIGSERIAL 사용
id VARCHAR(64) NOT NULL UNIQUE, -- UNIQUE 제약조건 추가
name TEXT NOT NULL,
status BOOLEAN NOT NULL DEFAULT false,
seq INT NOT NULL DEFAULT 0,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN todos.no IS 'PK';
COMMENT ON COLUMN todos.id IS 'UK';
COMMENT ON COLUMN todos.name IS '할일';
COMMENT ON COLUMN todos.status IS '상태';
COMMENT ON COLUMN todos.seq IS '순서';
COMMENT ON COLUMN todos.created_at IS '등록일자';
COMMENT ON COLUMN todos.updated_at IS '수정일자';

-- PostgreSQL에서 UUID 사용하는 방법
-- 아래 명령으로 pgcrypto 확장을 해주면 사용가능 하다.

-- CREATE EXTENSION IF NOT EXISTS "pgcrypto";
SELECT gen_random_uuid();

-- 테스트용 더미 데이터
insert into todos ( id, name) 
values
	( gen_random_uuid(), '할일1' ),
	( gen_random_uuid(), '할일2' ),
	( gen_random_uuid(), '할일3' ),
	( gen_random_uuid(), '할일4' ),
	( gen_random_uuid(), '할일5' ),
	( gen_random_uuid(), '할일6' ),
	( gen_random_uuid(), '할일7' ),
	( gen_random_uuid(), '할일8' ),
	( gen_random_uuid(), '할일9' ),
	( gen_random_uuid(), '할일10' )
;

select * from todos;