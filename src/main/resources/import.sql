--#######################################################
--## @author  : Md. Emran Hossain<emranhos1@gmail.com> ##
--## @create  : 2020-03-19T02:38:00                    ##
--## @version : 1.0.00                                 ##
--## @since   : 1.0.00                                 ##
--#######################################################

--#######################################################
--##                      T01001                       ##
--#######################################################
INSERT INTO T01001 VALUES(1, 'Dhaka', 'emranhos1@gmail.com', now(), 'Md. Emran', 1, 'Hossain', '01670932273', '1', now());
INSERT INTO T01001 VALUES(2, 'Dhaka', 'aaa@gmail.com', now(), 'AAA', 1, 'AAA', '01670932273', '2', now());
INSERT INTO T01001 VALUES(3, 'Dhaka', 'bbb@gmail.com', now(), 'BBB', 1, 'BBB', '01670932273', '3', now());

--#######################################################
--##                      T01002                       ##
--#######################################################
INSERT INTO T01002 VALUES(1, now(), 1, now(), 'Dhaka', 'Software', 'vendor1@gmail.com', 'VENDOR1', 'VENDOR1', '01670932273');
INSERT INTO T01002 VALUES(2, now(), 1, now(), 'Dhaka', 'Tender', 'vendor2@gmail.com', 'VENDOR2', 'VENDOR2', '01715909280');
INSERT INTO T01002 VALUES(3, now(), 1, now(), 'Dhaka', 'Parts', 'vendor3@gmail.com', 'VENDOR3', 'VENDOR3', '01919470902');

--#######################################################
--##                      T01003                       ##
--#######################################################
INSERT INTO T01003 VALUES(1, now(), 1, 'ADMIN', now());
INSERT INTO T01003 VALUES(2, now(), 1, 'VENDOR', now());
INSERT INTO T01003 VALUES(3, now(), 1, 'DISTRIBUTOR', now());

--#######################################################
--##                      T01004                       ##
--#######################################################
INSERT INTO T01004 VALUES(1, 'Software', 'Dhaka', 'emranhos1@gmail.com', 'Md. Emran', 'Hossain', '01670932273', now(), 1, now());
INSERT INTO T01004 VALUES(2, 'Parts', 'Dhaka', 'emranhos2@gmail.com', 'DDDD', 'DDDDD', '01670932273', now(), 1, now());
INSERT INTO T01004 VALUES(3, 'Tender', 'Dhaka', 'emranhos3@gmail.com', 'EEEEE', 'EEEEEE', '01670932273', now(), 1, now());

--#######################################################
--##                      T01005                       ##
--#######################################################
INSERT INTO T01005 VALUES(1, now(), 1, 'Ship', now());
INSERT INTO T01005 VALUES(2, now(), 1, 'Airplane', now());
INSERT INTO T01005 VALUES(3, now(), 1, 'Train', now());

--#######################################################
--##                      T01006                       ##
--#######################################################
INSERT INTO T01006 VALUES(1, '10000', now(), 1, '20000', now(), 1, 'PC', 100, '09876247525', 1, now());
INSERT INTO T01006 VALUES(2, '10000', now(), 2, '20000', now(), 1, 'PC', 100, '09876247525', 3, now());
INSERT INTO T01006 VALUES(3, '10000', now(), 3, '20000', now(), 1, 'PC', 100, '09876247525', 1, now());
INSERT INTO T01006 VALUES(4, '10000', now(), 1, '20000', now(), 1, 'PC', 100, '09876247525', 2, now());

--#######################################################
--##                      T01007                       ##
--#######################################################
INSERT INTO T01007 VALUES(1, '10000', now(), '20000', now(), 1, 'PC', 100, '09876247525', 1, now(), 1);
INSERT INTO T01007 VALUES(2, '10000', now(), '20000', now(), 1, 'PC', 100, '09876247525', 3, now(), 2);
INSERT INTO T01007 VALUES(3, '10000', now(), '20000', now(), 1, 'PC', 100, '09876247525', 1, now(), 3);
INSERT INTO T01007 VALUES(4, '10000', now(), '20000', now(), 1, 'PC', 100, '09876247525', 2, now(), 1);