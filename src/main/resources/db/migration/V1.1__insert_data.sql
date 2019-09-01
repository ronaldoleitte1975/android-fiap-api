INSERT INTO `heroku_2c8b6c05f4d3fa6`.`categorias` (`categoria`) VALUES ('Bebidas');
INSERT INTO `heroku_2c8b6c05f4d3fa6`.`categorias` (`categoria`) VALUES ('Doces');
INSERT INTO `heroku_2c8b6c05f4d3fa6`.`categorias` (`categoria`) VALUES ('Salgados');

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Coca-Cola em Lata',
'/img/coca-lata.jpg',
5.0,
'COCALATA',
24,
2);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Guraraná em Lata',
'/img/guarana-lata.jpg',
5.0,
'GUARANALATA',
12,
2);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Água mineral em garrafa',
'/img/agua-garrafa.jpg',
3.0,
'AGUAGARRAFA',
100,
2);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Cocada Caseira',
'/img/cocada-caseira.jpg',
5.0,
'COCADA',
24,
12);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Paçoca doce',
'/img/pacoca-doce.jpg',
1.0,
'PACOCA',
100,
12);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`produtos`
(`descricao`,
`foto`,
`preco`,
`produto`,
`qtde`,
`idCategoria`)
VALUES
('Batata Chips',
'/img/batata-chips.jpg',
7.5,
'BATATACHIPS',
140,
22);

INSERT INTO `heroku_2c8b6c05f4d3fa6`.`clientes`
(`bairro`,
`cep`,
`cidade`,
`email`,
`estado`,
`nome`,
`rua`,
`senha`)
VALUES
('Tatuapé',
'03086050',
'São Paulo',
'roclei31@yahoo.com.br',
'SP',
'Ronaldo Cerqueira Leite',
'Rua Felipe Camarão, 187',
'abc123');
