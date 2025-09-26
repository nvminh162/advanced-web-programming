-- Create database
CREATE
DATABASE IF NOT EXISTS www_c03_ex06;
USE
www_c03_ex06;

-- Create Catalog table
CREATE TABLE catalog
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    ten_danh_muc  VARCHAR(255) NOT NULL,
    nguoi_quan_ly VARCHAR(255),
    ghi_chu       TEXT
);

-- Create News table
CREATE TABLE news
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    tieu_de     VARCHAR(500) NOT NULL,
    noi_dung_tt TEXT,
    lien_ket    VARCHAR(1000),
    danh_muc_id BIGINT,
    FOREIGN KEY (danh_muc_id) REFERENCES catalog (id) ON DELETE SET NULL
);

-- Insert sample data for Catalog table
INSERT INTO catalog (ten_danh_muc, nguoi_quan_ly, ghi_chu)
VALUES ('Technology', 'John Smith', 'News about information technology, AI, blockchain'),
       ('Sports', 'Jane Doe', 'Football and international sports news'),
       ('Economy', 'Mike Johnson', 'Economic, financial, and stock market news'),
       ('Education', 'Sarah Wilson', 'Education, training, and admission news'),
       ('Health', 'David Brown', 'Medical and community health news'),
       ('Entertainment', 'Lisa Davis', 'Movie, music, and showbiz news'),
       ('Travel', 'Tom Anderson', 'Travel news and new destination discoveries');

-- Insert sample data for News table
INSERT INTO news (tieu_de, noi_dung_tt, lien_ket, danh_muc_id)
VALUES ('ChatGPT Launches New Version with Enhanced Features',
        'OpenAI has announced a new version of ChatGPT with improved image and audio processing capabilities, promising superior user experience.',
        'https://example.com/ai-chatgpt-new-version',
        1),

       ('Vietnam Wins SEA Games 32 Men\'s Football Gold Medal',
 'Vietnam U23 team excellently won the men\'s football gold medal at SEA Games 32 after a thrilling final match.',
        'https://example.com/vietnam-seagames-football',
        2),

       ('Vietnamese Stock Market Surges This Week',
        'VN-Index has increased more than 3% this week thanks to foreign capital inflow and positive investor sentiment.',
        'https://example.com/vietnam-stock-market-up',
        3),

       ('Ministry of Education Announces 2024 High School Graduation Exam Plan',
        'The 2024 high school graduation exam will be organized traditionally with 4 subjects.',
        'https://example.com/thpt-exam-2024',
        4),

       ('New Cancer Treatment Drug Discovered from Vietnamese Herbs',
        'Vietnamese scientists have successfully researched a new drug from traditional medicinal plants with high effectiveness in cancer treatment.',
        'https://example.com/vietnam-cancer-medicine',
        5),

       ('Vietnamese Film Wins Award at International Film Festival',
        'The film "Southern Forest Land" has won the Best Film award at the Asian Film Festival.',
        'https://example.com/vietnamese-film-award',
        6),

       ('Top 10 Most Attractive Tourist Destinations in Vietnam 2024',
        'Ha Long, Sapa, and Hoi An continue to lead the list of most beloved tourist destinations in Vietnam.',
        'https://example.com/top-vietnam-destinations-2024',
        7),

       ('Blockchain and Cryptocurrency: New Investment Trend',
        'Blockchain technology is being widely applied in many fields, opening new investment opportunities.',
        'https://example.com/blockchain-investment-trend',
        1),

       ('Ronaldo Extends Contract with Al-Nassr Until 2026',
        'Portuguese superstar Cristiano Ronaldo officially extended his contract with Al-Nassr club.',
        'https://example.com/ronaldo-contract-extension',
        2),

       ('Vietnamese Startup Successfully Raises $10 Million',
        'VinTech company has completed Series A funding round with a valuation of $50 million.',
        'https://example.com/vietnam-startup-funding',
        3);

SELECT * FROM news WHERE danh_muc_id = 1