CREATE TABLE IF NOT EXISTS EMPLOYEES(
    ID              SERIAL NOT NULL,
    CREATED_AT      timestamp NOT NULL,
    DELETED         BOOLEAN NOT NULL DEFAULT FALSE,
    UPDATED_AT      timestamp,
    FIRST_NAME      varchar(30) NOT NULL,
    SECOND_NAME     varchar(30),
    LAST_NAME_ONE   varchar(30) NOT NULL,
    LAST_NAME_TWO   varchar(30),
    GENDER          varchar(30),
    ID_NUMBER       varchar(20),
    ID_TYPE         varchar(16),
    EMAIL           varchar(50),
    CELLPHONE       varchar(20),

    constraint pk_employees_id primary key (id)
);

CREATE TABLE IF NOT EXISTS TASKS(
    ID                  SERIAL NOT NULL,
    CREATED_AT          timestamp NOT NULL,
    DELETED             BOOLEAN NOT NULL DEFAULT FALSE,
    UPDATED_AT          timestamp,
    STATUS              varchar (30) not null,
    ESTIMATED_DATE      timestamp,
    NAME                varchar (20) not null,
    DESCRIPTION         varchar (255),
    EMPLOYEE_ID         bigint not null,

    constraint pk_tasks_id primary key (id),
    constraint fk_tasks_employees foreign key (EMPLOYEE_ID) references EMPLOYEES(id)
);