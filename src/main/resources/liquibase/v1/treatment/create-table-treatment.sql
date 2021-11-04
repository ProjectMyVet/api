CREATE TABLE `treatment` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `attendance_id`		BIGINT UNSIGNED NOT NULL,
    `period`			VARCHAR(255) NOT NULL,
    `description`		VARCHAR(255) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_treatment_attendance_attendance_id` FOREIGN KEY ( `attendance_id` ) REFERENCES `attendance` ( `id` ) ON DELETE CASCADE
);
