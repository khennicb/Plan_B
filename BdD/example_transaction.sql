SET TRANSACTION READ WRITE NAME 'example';

SET TRANSACTION READ ONLY NAME 'example2';


rollback;

commit;