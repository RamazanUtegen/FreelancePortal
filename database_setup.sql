-- Таблица Фрилансеров
CREATE TABLE freelancers (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             skill VARCHAR(100) NOT NULL
);

-- Таблица Вакансий
CREATE TABLE job_listings (
                              id SERIAL PRIMARY KEY,
                              title VARCHAR(100) NOT NULL,
                              price DECIMAL(10, 2) NOT NULL
);

-- Таблица Заявок
CREATE TABLE applications (
                              id SERIAL PRIMARY KEY,
                              freelancer_id INT REFERENCES freelancers(id),
                              job_id INT REFERENCES job_listings(id),
                              status VARCHAR(20) DEFAULT 'PENDING'
);