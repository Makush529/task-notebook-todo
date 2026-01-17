create table public.logs
(
    id      bigserial,
    info    char(50),
    created timestamp
);

CREATE OR REPLACE FUNCTION addToLogs()
    RETURNS trigger
    LANGUAGE plpgsql
AS
$$
BEGIN
INSERT INTO logs(id, info, created)
VALUES (DEFAULT, 'added new user in base ' || new.user_id, now());
RETURN new;
END
$$;

CREATE TRIGGER addLogAfterCreatedNewUser
    AFTER INSERT ON users
    FOR EACH ROW
EXECUTE FUNCTION addToLogs();


