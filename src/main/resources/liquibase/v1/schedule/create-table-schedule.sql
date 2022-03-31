CREATE TABLE `schedule` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`			BIGINT UNSIGNED NOT NULL,
    `turn`				VARCHAR(30) NOT NULL,
    `day_of_week`		INTEGER NOT NULL,
    `from_time`			VARCHAR(30) NOT NULL,
    `to_time`			VARCHAR(30) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_schedule_user_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE
);
