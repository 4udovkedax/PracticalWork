CREATE TABLE public.users (
	id int NOT NULL,
    username varchar,
    fio varchar,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS logins
(
    id int NOT NULL,
    access_date timestamp without time zone,
    user_id bigint,
    application varchar,
    CONSTRAINT logins_pkey PRIMARY KEY (id),
    CONSTRAINT fk_users FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);