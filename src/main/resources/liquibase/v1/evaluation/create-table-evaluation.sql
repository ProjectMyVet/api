CREATE TABLE `evaluation` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `attendance_id`		BIGINT UNSIGNED NOT NULL,
    `grade`			    INTEGER NOT NULL,
    `description`		VARCHAR(255),
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_evaluation_attendance_attendance_id` FOREIGN KEY ( `attendance_id` ) REFERENCES `attendance` ( `id` ) ON DELETE CASCADE
);