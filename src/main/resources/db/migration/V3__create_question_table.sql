CREATE TABLE QUESTION
(
    id INT AUTO_INCREMENT,
    title VARCHAR(50),
    description TEXT,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    creator INT,
    comment_count INT DEFAULT 0,
    view_count INT DEFAULT 0,
    like_count INT DEFAULT 0,
    tag VARCHAR(256)
);
COMMENT ON COLUMN QUESTION.id IS 'id';
COMMENT ON COLUMN QUESTION.title IS '标题';
COMMENT ON COLUMN QUESTION.description IS '问题描述';
COMMENT ON COLUMN QUESTION.gmt_create IS '创建时间';
COMMENT ON COLUMN QUESTION.gmt_modified IS '修改时间';
COMMENT ON COLUMN QUESTION.creator IS '创建者';
COMMENT ON COLUMN QUESTION.comment_count IS '评论数量';
COMMENT ON COLUMN QUESTION.view_count IS '浏览次数';
COMMENT ON COLUMN QUESTION.like_count IS '收藏数量';
COMMENT ON TABLE QUESTION IS '问题';