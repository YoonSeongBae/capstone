-- users 테이블 생성
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    level VARCHAR(50) NOT NULL
);

-- exercises 테이블 생성
CREATE TABLE Exercises (
    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image BLOB
);

-- routines 테이블 생성
CREATE TABLE Routines (
    routine_id INT AUTO_INCREMENT PRIMARY KEY,
    level VARCHAR(50) NOT NULL,
    set_count INT NOT NULL,
    rep_count INT NOT NULL
);

-- user_routines 테이블 생성
CREATE TABLE UserRoutines (
    user_routine_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    routine_id INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (routine_id) REFERENCES Routines(routine_id)
);

-- routine_exercises 테이블 생성
CREATE TABLE RoutineExercises (
    routine_exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    routine_id INT NOT NULL,
    exercise_id INT NOT NULL,
    sequence INT NOT NULL,
    FOREIGN KEY (routine_id) REFERENCES Routines(routine_id),
    FOREIGN KEY (exercise_id) REFERENCES Exercises(exercise_id)
);
