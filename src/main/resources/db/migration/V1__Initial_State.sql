create sequence users_users_id_seq;

create table users
(
    user_id  bigint default nextval('users_users_id_seq'::regclass) not null
        constraint users_pk
            primary key,
    username varchar(10)                                            not null,
    password varchar(10)                                            not null
);

alter sequence users_users_id_seq owned by users.user_id;

create unique index username_index
    on users (username);

create table tasks
(
    task_id     bigserial
        constraint tasks_pk
            primary key,
    task        text not null,
    username_id bigint
        constraint tasks_fk
            references users
            on update cascade on delete cascade
);