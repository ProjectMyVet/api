CREATE TABLE `user` (
	`id`				BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`id_token`			VARCHAR(255) NOT NULL,
	`name`				VARCHAR(255) NOT NULL,
	`email`				VARCHAR(255) NOT NULL,
	`type`				VARCHAR(30) NOT NULL,
	`photo_url`			VARCHAR(2048) NOT NULL,
	`created_at`		DATETIME NOT NULL,
	`updated_at`		DATETIME NOT NULL,
	PRIMARY KEY ( `id` )
);