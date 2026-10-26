alter table pacientes add column ativo tinyint;
alter table pacientes modify ativo tinyint not null;