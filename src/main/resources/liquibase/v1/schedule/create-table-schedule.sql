CREATE TABLE `schedule` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`			BIGINT UNSIGNED NOT NULL,
    `turn`				VARCHAR(30) NOT NULL,
    `from_date`			DATETIME NOT NULL,
    `to_date`			DATETIME NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_schedule_user_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE
);
