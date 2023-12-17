#### Создаем таблицу с информацией о сотрудниках

CREATE TABLE worker (
  worker_id INTEGER PRIMARY KEY,
  shop_id INTEGER REFERENCES product (id),
  name VARCHAR(255),
  salary INTEGER NOT NULL,
  position VARCHAR(255)
);

#### Заполним таблицу данными

INSERT INTO worker (worker_id, shop_id, name, salary, position) VALUES
  (0, 2, 'Работник 0', 45000, 'Продавец'),
  (1, 1, 'Работник 1', 30000, 'Продавец'),
  (2, 2, 'Работник 2', 40000, 'Стажер'),
  (3, 1, 'Работник 3', 50000, 'Директор'),
  (4, 3, 'Работник 4', 60000, 'Администратор')

#### Напишем несолько запросов

SELECT position, AVG(salary) FROM worker GROUP BY position;
(средняя зарплата по должностям)

SELECT shop_id, COUNT(*) FROM worker GROUP BY shop_id
(количество сотрудников в каждом магазине)

SELECT * FROM worker ORDER BY salary ASC;
(список сотрудников, отсортированный по возрастанию зарплаты)

SELECT SUM(salary) FROM worker;
(общая сумма зарплаты всех сотрудников)

SELECT MAX(salary) FROM worker;
(максимальная зарплата среди сотрудников)