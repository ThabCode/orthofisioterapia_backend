	INSERT INTO `tipo_paciente` (`id_tipo_paciente`, `nome_tipo_paciente`) VALUES (1, 'Local');
	INSERT INTO `tipo_paciente` (`id_tipo_paciente`, `nome_tipo_paciente`) VALUES (2, 'Convenio');
	INSERT INTO `tipo_paciente` (`id_tipo_paciente`, `nome_tipo_paciente`) VALUES (3, 'Particular');
		
	INSERT INTO `paciente` (`id_paciente`, `cpf_paciente`, `criado_em`, `data_nasc`, `email_paciente`, `password`,`nome_paciente`, `id_tipo_paciente`) VALUES ('001', '01203855389', '2022-07-05', '1987-09-06', 'abmael_ninha@hotmail.com','$2a$10$MpDoWzouPn/XhML1M8T1Ku1dLXT5HuW2gG5xXbJjLu7OFQzIgYabK', 'Abmael de Lima Ferreira', 1);
	
	INSERT INTO `role` (`paciente_id_paciente`, `roles`) values (001, 1);
	
	
	INSERT INTO `atendimento` (`id_atend`, `criado_em`, `desc_atend`, `valor_atend`) VALUES ('001', '2022-07-07 00:00', 'Eletro Fisioterapia', '5000');
	INSERT INTO `atendimento` (`id_atend`, `criado_em`, `desc_atend`, `valor_atend`) VALUES ('002', '2022-07-07 00:00', 'Fisio Traumato', '25000');
	INSERT INTO `atendimento` (`id_atend`, `criado_em`, `desc_atend`, `valor_atend`) VALUES ('003', '2022-07-07 00:00', 'Pilates 2 Vezes', '35000');
	INSERT INTO `atendimento` (`id_atend`, `criado_em`, `desc_atend`, `valor_atend`) VALUES ('004', '2022-07-07 00:00', 'Fisio Muscular', '35000');
	
	INSERT INTO `tipo_atendimento` (`id_tipo_aten`, `nome_tipo_atend`) VALUES ('1', 'Pilates');
	INSERT INTO `tipo_atendimento` (`id_tipo_aten`, `nome_tipo_atend`) VALUES ('2', 'Fisioiterapia');
	INSERT INTO `tipo_atendimento` (`id_tipo_aten`, `nome_tipo_atend`) VALUES ('3',  'Eletro' );
	
	INSERT INTO `atendimento_tipo_atendimento` (`id_atend`, `id_tipo_atend`) VALUES (1,3);
	INSERT INTO `atendimento_tipo_atendimento` (`id_atend`, `id_tipo_atend`) VALUES (2,2);
	INSERT INTO `atendimento_tipo_atendimento` (`id_atend`, `id_tipo_atend`) VALUES (3,1);
	INSERT INTO `atendimento_tipo_atendimento` (`id_atend`, `id_tipo_atend`) VALUES (4,2);
