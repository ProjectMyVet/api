CREATE TABLE `reminder` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`			BIGINT UNSIGNED NOT NULL,
    `date`				DATETIME NOT NULL,
    `action`			VARCHAR(255) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_reminder_user_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE
);
