-- agencias, sendo a primeira, a global
insert into agencia (agencia, nome_agencia) values ('000-0', "Global");
insert into agencia (agencia, nome_agencia) values ('030-7', "Centro");
insert into agencia (agencia, nome_agencia) values ('080-2', "Petropolis");

-- registro do proprio banco para criacao da conta interna do banco (sem enderecos e sem contatos)
insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj) values ('99524991000179',null,null,'Blue Bank',null,null,'J');
insert into conta (num_conta,digito,tipo_conta,id_agencia,id_correntista) values (1,8,'Contabil Interna',1,1);

-- registros de correntistas normais com seus enderecos e contatos
insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj) values (null,'76712703000','carlos@sistelpa.com','Carlos Betiol','4444444-4','45991157171','F');
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero) values ('Jardim Taroba','85858555','Foz do Iguacu',null,'PR',2,'Rua Londres','225');
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero) values ('Centro','85851000','Foz do Iguacu',null,'PR',2,'Av Republica Argentina','950');
insert into contato_cliente (email,id_correntista,info_recado,telefone) values ('carlos@sistelpa.com',2,'o proprio','45991157171');
insert into contato_cliente (email,id_correntista,info_recado,telefone) values (null,2,'Joana (mae)','45999295454');

insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj) values ('24992259000124',null,'carlos@betiol.dev','Five Devs Tecnologia',null,'45991157171','J');
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero) values ('Aclimacao','00858555','São Paulo',null,'SP',3,'Rua do Angico','6225');
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero) values ('Consolacao','00151000','São Paulo',null,'SP',3,'Av Paulista','2950');
insert into contato_cliente (email,id_correntista,info_recado,telefone) values ('carlos@betiol.dev',3,'Carlos Betiol','45991157171');
insert into contato_cliente (email,id_correntista,info_recado,telefone) values ('jonas@gmail.com',3,'Jonas W','11999145454');

insert into conta (num_conta,digito,tipo_conta,id_agencia,id_correntista) values (2,6,'Corrente',2,2);
insert into conta (num_conta,digito,tipo_conta,id_agencia,id_correntista) values (3,4,'Poupanca',2,2);
insert into conta (num_conta,digito,tipo_conta,id_agencia,id_correntista) values (4,2,'Corrente',3,3);
insert into conta (num_conta,digito,tipo_conta,id_agencia,id_correntista) values (5,9,'Poupanca',3,3);
