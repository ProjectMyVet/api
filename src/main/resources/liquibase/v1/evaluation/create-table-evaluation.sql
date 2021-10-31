CREATE TABLE `evaluation` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `attendence_id`		BIGINT UNSIGNED NOT NULL,
    `period`			VARCHAR(255) NOT NULL,
    `description`		VARCHAR(255) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_evaluation_attendence_attendence_id` FOREIGN KEY ( `attendence_id` ) REFERENCES `attendence` ( `id` ) ON DELETE CASCADE
);