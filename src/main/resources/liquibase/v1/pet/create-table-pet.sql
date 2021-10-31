CREATE TABLE `pet` (
    `id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `vet_id`			BIGINT UNSIGNED NOT NULL,
    `name`				VARCHAR(255) NOT NULL,
    `birth_date`		DATETIME NOT NULL,
    `breed`				VARCHAR(255) NOT NULL,
    `created_at`		DATETIME NOT NULL,
    `updated_at`		DATETIME NOT NULL,
    PRIMARY KEY ( `id` ),
    CONSTRAINT `fk_pet_user_user_id` FOREIGN KEY ( `vet_id` ) REFERENCES `user` ( `id` ) ON DELETE CASCADE
);
