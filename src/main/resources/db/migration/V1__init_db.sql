create table if not exists public._user
(
    id         integer not null
    primary key,
    active     boolean not null,
    email      varchar(255)
    constraint uk_k11y3pdtsrjgy8w9b6q4bjwrx
    unique,
    firstname  varchar(255),
    lastname   varchar(255),
    password   varchar(255),
    account_id integer
    );

create table if not exists public.account
(
    id      integer not null
    primary key,
    iban    varchar(255)
    constraint uk_cuc1pxk2ofct9xra2nm0oon
    unique,
    user_id integer
    constraint fkcw93h2ubdxfaq2jqapsqaqcs3
    references public._user
    );

alter table public._user
    add constraint fkiss2d6w8t4kem97wnfwa0vf0
        foreign key (account_id) references public.account;

create table if not exists public.contact
(
    id        integer not null
    primary key,
    email     varchar(255)
    constraint uk_gnqwbwwcn7x0m5jlt4158dass
    unique,
    firstname varchar(255),
    iban      varchar(255),
    lastname  varchar(255),
    user_id   integer
    constraint fkk67bi8ta1qqhx05sichhhk2l4
    references public._user
    );

create table if not exists public.role
(
    id   integer not null
    primary key,
    name varchar(255)
    constraint uk_8sewwnpamngi6b1dwaa88askk
    unique
    );

create table if not exists public._user_roles
(
    users_id integer not null
    constraint fkkna43mk14wb08rt62w1982ki6
    references public._user,
    roles_id integer not null
    constraint fktq7v0vo9kka3qeaw2alou2j8p
    references public.role
);

create table if not exists public.transaction
(
    id               integer not null
    primary key,
    amount           numeric(38, 2),
    destination_iban varchar(255),
    transaction_date date,
    type             varchar(255),
    user_id          integer
    constraint fkh6gptwbv2pjrtwqbrpdvxos11
    references public._user
    );

create sequence public._user_seq
    increment by 50;

create sequence public.account_seq
    increment by 50;


create sequence public.contact_seq
    increment by 50;


create sequence public.role_seq
    increment by 50;


create sequence public.transaction_seq
    increment by 50;
