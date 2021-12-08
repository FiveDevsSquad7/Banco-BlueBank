SET GLOBAL log_bin_trust_function_creators = 1;

CREATE DEFINER=`root`@`%` FUNCTION `f_saldo_conta`(`pConta` Long, `pData` date) RETURNS decimal(19,2) READS SQL DATA return (select (ifnull((select sum(a.valor) from movimentacao as a where a.num_conta_debito=pConta and cast(a.data_movimento as date) <= pData),0) - ifnull((select sum(a.valor) from movimentacao as a where a.num_conta_credito=pConta and cast(a.data_movimento as date) <= pData),0)));

-- agencias, sendo a primeira, a global
insert into agencia (agencia, nome_agencia, data_cadastro) values ('000-0', "Global", utc_timestamp);
insert into agencia (agencia, nome_agencia, data_cadastro) values ('030-7', "Centro", utc_timestamp);
insert into agencia (agencia, nome_agencia, data_cadastro) values ('080-2', "Petropolis", utc_timestamp);

-- registro do proprio banco para criacao da conta interna do banco (sem enderecos e sem contatos)
-- as contas de codigo 1 e 2 servirao para disponibilizacao do saldo inicial (a conta 1 tera codigo
-- credor para a contrapartida nas contas dos correntistas)
insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj,data_cadastro) values ('99524991000179',null,null,'Blue Bank',null,null,'J', utc_timestamp);
insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('AD',1,1,'123', utc_timestamp);
insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('AC',1,1,'123', utc_timestamp);

-- registros de correntistas normais com seus enderecos e contatos
insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj,data_cadastro) values (null,'76712703000','carlos@sistelpa.com','Carlos Betiol','4444444-4','45991157171','F', utc_timestamp);
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero,data_cadastro) values ('Jardim Taroba','85858555','Foz do Iguacu',null,'PR',2,'Rua Londres','225', utc_timestamp);
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero,data_cadastro) values ('Centro','85851000','Foz do Iguacu',null,'PR',2,'Av Republica Argentina','950', utc_timestamp);
insert into contato_cliente (email,id_correntista,info_recado,telefone,data_cadastro) values ('carlos@sistelpa.com',2,'o proprio','45991157171', utc_timestamp);
insert into contato_cliente (email,id_correntista,info_recado,telefone,data_cadastro) values (null,2,'Joana (mae)','45999295454', utc_timestamp);

insert into correntista (cnpj,cpf,email_validacao,nome,rg,sms_validacao,pf_pj,data_cadastro) values ('24992259000124',null,'carlos@betiol.dev','Five Devs Tecnologia',null,'45991157171','J', utc_timestamp);
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero,data_cadastro) values ('Aclimacao','00858555','São Paulo',null,'SP',3,'Rua do Angico','6225', utc_timestamp);
insert into endereco (bairro,cep,cidade,complemento,estado,id_correntista,logradouro,numero,data_cadastro) values ('Consolacao','00151000','São Paulo',null,'SP',3,'Av Paulista','2950', utc_timestamp);
insert into contato_cliente (email,id_correntista,info_recado,telefone,data_cadastro) values ('carlos@betiol.dev',3,'Carlos Betiol','45991157171', utc_timestamp);
insert into contato_cliente (email,id_correntista,info_recado,telefone,data_cadastro) values ('jonas@gmail.com',3,'Jonas W','11999145454', utc_timestamp);

insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('CC',2,2,'123', utc_timestamp);
insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('PP',2,2,'123', utc_timestamp);
insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('CC',3,3,'123', utc_timestamp);
insert into conta (tipo_conta,id_agencia,id_correntista,senha,data_cadastro) values ('PP',3,3,'123', utc_timestamp);

insert into movimentacao (data_movimento,descricao,num_conta_debito,num_conta_credito,valor) values (utc_timestamp,'Saldo inicial para a conta administrativa',1,2,1000000000.0);
