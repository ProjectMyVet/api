CREATE TABLE `medication` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`			BIGINT UNSIGNED NOT NULL,
    `pet_id`			BIGINT UNSIGNED NOT NULL,
    `type`				VARCHAR(255) NOT NULL,
    `description`		VARCHAR(255) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_medication_user_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE,
    CONSTRAINT `fk_medication_pet_pet_id` FOREIGN KEY ( `pet_id` ) REFERENCES `pet` ( `id` ) ON DELETE CASCADE
);
