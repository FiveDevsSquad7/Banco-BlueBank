
    create table agencia (
       id_agencia bigint not null auto_increment,
        agencia varchar(255),
        nome_agencia varchar(255),
        primary key (id_agencia)
    ) engine=InnoDB;

    create table conta (
       id_conta bigint not null auto_increment,
        digito integer not null,
        num_conta integer,
        tipo_conta varchar(255),
        id_agencia bigint not null,
        id_correntista bigint,
        primary key (id_conta)
    ) engine=InnoDB;

    create table contato_cliente (
       id_contato_pessoa bigint not null auto_increment,
        email varchar(255),
        info_recado varchar(255),
        telefone varchar(255),
        id_correntista bigint not null,
        primary key (id_contato_pessoa)
    ) engine=InnoDB;

    create table correntista (
       id_correntista bigint not null auto_increment,
        cnpj varchar(14) not null,
        cpf varchar(11) not null,
        email_validacao varchar(255),
        nome varchar(255),
        rg varchar(255),
        sms_validacao varchar(255),
        pf_pj char(1),
        primary key (id_correntista)
    ) engine=InnoDB;

    create table endereco (
       id_endereco bigint not null auto_increment,
        bairro varchar(255),
        cep varchar(255),
        cidade varchar(255),
        complemento varchar(255),
        estado varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        id_correntista bigint not null,
        primary key (id_endereco)
    ) engine=InnoDB;

    create table movimentacao (
       id_movimentacao bigint not null auto_increment,
        data_movimento datetime(6),
        descricao varchar(255),
        valor decimal(19,2),
        id_conta_credito bigint,
        id_conta_debito bigint,
        primary key (id_movimentacao)
    ) engine=InnoDB;

    create table saldo (
       id_saldo bigint not null auto_increment,
        data_saldo datetime(6) not null,
        saldo decimal(19,2),
        id_conta bigint,
        primary key (id_saldo)
    ) engine=InnoDB;

    alter table conta 
       add constraint FKtmilqgg5bepovks0ramh4yvjt 
       foreign key (id_agencia) 
       references agencia (id_agencia);

    alter table conta 
       add constraint FKs6r5degxvj1v7uisa5r0g9h9o 
       foreign key (id_correntista) 
       references correntista (id_correntista);

    alter table contato_cliente 
       add constraint FKnl65b62b7bblpgv88iatjhg52 
       foreign key (id_correntista) 
       references correntista (id_correntista);

    alter table endereco 
       add constraint FK652qj4p1gk7is6fc3p6snlkav 
       foreign key (id_correntista) 
       references correntista (id_correntista);

    alter table movimentacao 
       add constraint FK4jo7kthty3s5bygb4e7num9qq 
       foreign key (id_conta_credito) 
       references conta (id_conta);

    alter table movimentacao 
       add constraint FK4rf172xa6splavqiuw18k9nbi 
       foreign key (id_conta_debito) 
       references conta (id_conta);

    alter table saldo 
       add constraint FKkx02rssisu288juv16kklfpd6 
       foreign key (id_conta) 
       references conta (id_conta);

insert into agencia (agencia, nome_agencia) values ('020-3', "Centro");
insert into agencia (agencia, nome_agencia) values ('030-7', "Cataratas");
