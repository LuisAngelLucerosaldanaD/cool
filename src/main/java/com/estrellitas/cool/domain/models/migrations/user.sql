CREATE TABLE IF NOT EXISTS auth.users(
    id UUID NOT NULL,
    names varchar(50) not null;
    lastname varchar(50) not null;
    email varchar(100) not null;
    age int not null;
    password varchar(255) not null;
    gender varchar(10) not null;
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    CONSTRAINT PK_auth_users PRIMARY KEY  ( id )
);