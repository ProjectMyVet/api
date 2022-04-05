CREATE TABLE `attendance` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `customer_id`		BIGINT UNSIGNED NOT NULL,
    `vet_id`			BIGINT UNSIGNED NOT NULL,
    `pet_id`			BIGINT UNSIGNED NOT NULL,
    `status`			VARCHAR(30) NOT NULL,
    `type`				VARCHAR(30) NOT NULL,
    `turn`				VARCHAR(30) NOT NULL,
    `attendance_date`	DATETIME NOT NULL,
    `from_time`			VARCHAR(30) NOT NULL,
    `to_time`			VARCHAR(30) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_attendance_user_customer_id` FOREIGN KEY ( `customer_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE,
    CONSTRAINT `fk_attendance_user_vet_id` FOREIGN KEY ( `vet_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE,
    CONSTRAINT `fk_attendance_pet_pet_id` FOREIGN KEY ( `pet_id` ) REFERENCES `pet` ( `id` ) ON DELETE CASCADE
);
