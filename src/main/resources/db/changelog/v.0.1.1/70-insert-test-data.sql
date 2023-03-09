INSERT INTO `manager` (`id`, `first_name`, `last_name`, `status`)
VALUES (1, 'Albina', 'Schmidt', 0),
       (2, 'Luise', 'Weber', 0),
       (3, 'Kristian', 'Wagner', 0),
       (4, 'Monika', 'Becker', 0),
       (5, 'Jasper', 'Otto', 1),
       (6, 'Eike', 'Kaiser', 2);


INSERT INTO `client` (`id`, `manager_id`, `status`, `tax_code`, `first_name`, `last_name`, `email`, `address`, `phone`)
VALUES (unhex(replace('80cf3044-b1cd-11ed-8545-08979887bb18', '-', '')), 1, 1,
        '8254547854875', 'Margareta', 'Fleischmann', 'mina46@t-online.de',
        'Tina-Schütz-Gasse 5/4 24476', '+49 (0) 1571 948627'),
       (unhex(replace('4c15d4b3-b1d3-11ed-8545-08979887bb18', '-', '')), 2, 1, '8254798798798', 'Ivonne', 'Friedrich',
        'bach.burghard@haupt.com', 'Heinemannstr. 24c 07535', '+49 (0) 3776 836765'),
       (unhex(replace('4c15d4f1-b1d3-11ed-8545-08979887bb18', '-', '')), 3, 1, '8259878743213', 'Ina', 'Wolf',
        'schulte.kristina@korner.com', 'Ebertplatz 26c 84609', '+49(0)3237775284'),
       (unhex(replace('5cd16c92-b1d3-11ed-8545-08979887bb18', '-', '')), 1, 1, '8259876543643', 'Margarita', 'Rausch',
        'hansjochen.neubauer@gmail.com', 'Daniela-Bachmann-Gasse 485 57781', '+49(0)3237775284'),
       (unhex(replace('a04b2b18-b1d3-11ed-8545-08979887bb18', '-', '')), 4, 1, '8284365165465', 'Peter', 'Graf',
        'kunz.markus@lorenz.com', 'Lore-Ebert-Allee 3 99611', '+49(0) 360895833'),
       (unhex(replace('ae6c8264-b1d4-11ed-8545-08979887bb18', '-', '')), 4, 1, '8283268546545', 'Eberhard', 'Michel',
        'graf.sergej@engelhardt.com', 'Breuerstr. 6 71974', '+49(0)5554 19291"');


INSERT INTO `account` (`id`, `client_id`, `name`, `type`, `status`, `balance`, `currency_code`)
VALUES (unhex(replace('b8ed7c33-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4c15d4f1-b1d3-11ed-8545-08979887bb18', '-', '')), 'account Wolf', 1, 0, 100.00, 1),
       (unhex(replace('e5655ad4-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('80cf3044-b1cd-11ed-8545-08979887bb18', '-', '')), 'account Fleischmann_1', 2, 0, 25000.00, 2),
       (unhex(replace('4ce519a0-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('80cf3044-b1cd-11ed-8545-08979887bb18', '-', '')), 'account Fleischmann_2', 2, 0, 3800.00, 3),
       (unhex(replace('4ce51a24-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4c15d4b3-b1d3-11ed-8545-08979887bb18', '-', '')), 'account Friedrich_1', 2, 0, 400.00, 1),
       (unhex(replace('5e938b24-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('5cd16c92-b1d3-11ed-8545-08979887bb18', '-', '')), 'account Rausch_1', 2, 0, 500.00, 3),
       (unhex(replace('72c98cb4-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('5cd16c92-b1d3-11ed-8545-08979887bb18', '-', '')), 'account Rausch_2', 2, 0, 600.00, 1),
       (unhex(replace('72c98cd3-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('a04b2b18-b1d3-11ed-8545-08979887bb18', '-', '')), 'account Graf', 2, 0, 1700.00, 2),
       (unhex(replace('72c98cd7-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('ae6c8264-b1d4-11ed-8545-08979887bb18', '-', '')), 'account Michel_1', 2, 0, 850.00, 2),
       (unhex(replace('72c98cdb-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('ae6c8264-b1d4-11ed-8545-08979887bb18', '-', '')), 'account Michel_2', 2, 0, 900.00, 3);


INSERT INTO `transaction` (`id`, `debit_account_id`, `credit_account_id`, `type`, `amount`, `description`)
VALUES (unhex(replace('38820e01-b1ce-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('e5655ad4-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('b8ed7c33-b1cd-11ed-8545-08979887bb18', '-', '')), 1, 180, 'transaction 1'),
       (unhex(replace('f42cf7fa-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('e5655ad4-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('5e938b24-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 1200, 'transaction 2'),
       (unhex(replace('f42cf819-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('b8ed7c33-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('72c98cdb-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 155, 'transaction 3'),
       (unhex(replace('f42cf81d-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('b8ed7c33-b1cd-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4ce51a24-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 49, 'transaction 4'),
       (unhex(replace('f42cf821-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('72c98cb4-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('72c98cdb-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 3580, 'transaction 5'),
       (unhex(replace('f42cf825-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('72c98cd7-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4ce519a0-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 180, 'transaction 6'),
       (unhex(replace('f42cf828-b1d9-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('72c98cdb-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4ce51a24-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 120, 'transaction 7'),
       (unhex(replace('0a17b3e8-b1da-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('5e938b24-b1d5-11ed-8545-08979887bb18', '-', '')),
        unhex(replace('4ce519a0-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 350, 'transaction 8');


INSERT INTO `product` (`manager_id`, `name`, `status`, `currency_code`, `interest_rate`, `limit`)
VALUES (1, 'Deposit', 0, 1, 15, 1000000),
       (2, 'Credit', 0, 1, 5, 10000),
       (2, 'Mortgage', 0, 2, 4, 2000),
       (3, 'Ipoteka', 0, 1, 2, 1000000),
       (3, 'Ipoteka', 0, 2, 3, 150000),
       (1, 'Car loan', 0, 2, 12, 10000);

INSERT INTO agreement (account_id, product_id, interest_rate, status, sum)
VALUES (unhex(replace('b8ed7c33-b1cd-11ed-8545-08979887bb18', '-', '')), 1, 15, 0, 10500),
       (unhex(replace('4ce519a0-b1d5-11ed-8545-08979887bb18', '-', '')), 1, 5, 0, 10000),
       (unhex(replace('5e938b24-b1d5-11ed-8545-08979887bb18', '-', '')), 3, 4, 0, 50000),
       (unhex(replace('72c98cb4-b1d5-11ed-8545-08979887bb18', '-', '')), 4, 2, 0, 38000),
       (unhex(replace('72c98cd3-b1d5-11ed-8545-08979887bb18', '-', '')), 3, 3, 0, 50000),
       (unhex(replace('72c98cd7-b1d5-11ed-8545-08979887bb18', '-', '')), 6, 12, 0, 2000);