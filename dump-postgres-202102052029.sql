PGDMP                         y            postgres    10.15    10.15 .    _           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            `           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            a           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    24732    project0    SCHEMA        CREATE SCHEMA project0;
    DROP SCHEMA project0;
             postgres    false            �            1259    24739    car    TABLE     �   CREATE TABLE project0.car (
    carid integer NOT NULL,
    make character varying NOT NULL,
    model character varying NOT NULL,
    year character varying,
    status character varying NOT NULL,
    userid integer
);
    DROP TABLE project0.car;
       project0         postgres    false    7            �            1259    24780    cars_carid_seq    SEQUENCE     �   CREATE SEQUENCE project0.cars_carid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE project0.cars_carid_seq;
       project0       postgres    false    219    7            b           0    0    cars_carid_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE project0.cars_carid_seq OWNED BY project0.car.carid;
            project0       postgres    false    224            �            1259    24733    user    TABLE       CREATE TABLE project0."user" (
    userid integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    type character varying NOT NULL
);
    DROP TABLE project0."user";
       project0         postgres    false    7            �            1259    24748    customers_customerid_seq    SEQUENCE     �   CREATE SEQUENCE project0.customers_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE project0.customers_customerid_seq;
       project0       postgres    false    7    218            c           0    0    customers_customerid_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE project0.customers_customerid_seq OWNED BY project0."user".userid;
            project0       postgres    false    222            �            1259    24880    loan    TABLE       CREATE TABLE project0.loan (
    loanid integer NOT NULL,
    purchaseprice numeric(8,2) NOT NULL,
    interest numeric(8,2) NOT NULL,
    userid integer NOT NULL,
    carid integer NOT NULL,
    payments_remaining integer DEFAULT 60 NOT NULL,
    payment_amount numeric
);
    DROP TABLE project0.loan;
       project0         postgres    false    7            �            1259    24878    loan_loanid_seq    SEQUENCE     �   CREATE SEQUENCE project0.loan_loanid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE project0.loan_loanid_seq;
       project0       postgres    false    227    7            d           0    0    loan_loanid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE project0.loan_loanid_seq OWNED BY project0.loan.loanid;
            project0       postgres    false    226            �            1259    24745    offer    TABLE       CREATE TABLE project0.offer (
    offerid integer NOT NULL,
    userid integer NOT NULL,
    firstname character varying,
    lastname character varying,
    carid integer NOT NULL,
    make character varying,
    model character varying,
    amount numeric(8,2) NOT NULL
);
    DROP TABLE project0.offer;
       project0         postgres    false    7            �            1259    24766    offers_offerid_seq    SEQUENCE     �   CREATE SEQUENCE project0.offers_offerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE project0.offers_offerid_seq;
       project0       postgres    false    221    7            e           0    0    offers_offerid_seq    SEQUENCE OWNED BY     L   ALTER SEQUENCE project0.offers_offerid_seq OWNED BY project0.offer.offerid;
            project0       postgres    false    223            �            1259    24742    payment    TABLE     S  CREATE TABLE project0.payment (
    paymentid integer NOT NULL,
    date date NOT NULL,
    amount numeric(8,2) NOT NULL,
    userid integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    make character varying NOT NULL,
    model character varying NOT NULL,
    carid integer NOT NULL
);
    DROP TABLE project0.payment;
       project0         postgres    false    7            �            1259    24791    payments_paymentid_seq    SEQUENCE     �   CREATE SEQUENCE project0.payments_paymentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE project0.payments_paymentid_seq;
       project0       postgres    false    7    220            f           0    0    payments_paymentid_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE project0.payments_paymentid_seq OWNED BY project0.payment.paymentid;
            project0       postgres    false    225            �
           2604    24782 	   car carid    DEFAULT     k   ALTER TABLE ONLY project0.car ALTER COLUMN carid SET DEFAULT nextval('project0.cars_carid_seq'::regclass);
 :   ALTER TABLE project0.car ALTER COLUMN carid DROP DEFAULT;
       project0       postgres    false    224    219            �
           2604    24883    loan loanid    DEFAULT     n   ALTER TABLE ONLY project0.loan ALTER COLUMN loanid SET DEFAULT nextval('project0.loan_loanid_seq'::regclass);
 <   ALTER TABLE project0.loan ALTER COLUMN loanid DROP DEFAULT;
       project0       postgres    false    226    227    227            �
           2604    24768    offer offerid    DEFAULT     s   ALTER TABLE ONLY project0.offer ALTER COLUMN offerid SET DEFAULT nextval('project0.offers_offerid_seq'::regclass);
 >   ALTER TABLE project0.offer ALTER COLUMN offerid DROP DEFAULT;
       project0       postgres    false    223    221            �
           2604    24793    payment paymentid    DEFAULT     {   ALTER TABLE ONLY project0.payment ALTER COLUMN paymentid SET DEFAULT nextval('project0.payments_paymentid_seq'::regclass);
 B   ALTER TABLE project0.payment ALTER COLUMN paymentid DROP DEFAULT;
       project0       postgres    false    225    220            �
           2604    24750    user userid    DEFAULT     y   ALTER TABLE ONLY project0."user" ALTER COLUMN userid SET DEFAULT nextval('project0.customers_customerid_seq'::regclass);
 >   ALTER TABLE project0."user" ALTER COLUMN userid DROP DEFAULT;
       project0       postgres    false    222    218            T          0    24739    car 
   TABLE DATA               I   COPY project0.car (carid, make, model, year, status, userid) FROM stdin;
    project0       postgres    false    219            \          0    24880    loan 
   TABLE DATA               t   COPY project0.loan (loanid, purchaseprice, interest, userid, carid, payments_remaining, payment_amount) FROM stdin;
    project0       postgres    false    227            V          0    24745    offer 
   TABLE DATA               c   COPY project0.offer (offerid, userid, firstname, lastname, carid, make, model, amount) FROM stdin;
    project0       postgres    false    221            U          0    24742    payment 
   TABLE DATA               m   COPY project0.payment (paymentid, date, amount, userid, firstname, lastname, make, model, carid) FROM stdin;
    project0       postgres    false    220            S          0    24733    user 
   TABLE DATA               V   COPY project0."user" (userid, firstname, lastname, email, password, type) FROM stdin;
    project0       postgres    false    218            g           0    0    cars_carid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('project0.cars_carid_seq', 7, true);
            project0       postgres    false    224            h           0    0    customers_customerid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('project0.customers_customerid_seq', 12, true);
            project0       postgres    false    222            i           0    0    loan_loanid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('project0.loan_loanid_seq', 8, true);
            project0       postgres    false    226            j           0    0    offers_offerid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('project0.offers_offerid_seq', 21, true);
            project0       postgres    false    223            k           0    0    payments_paymentid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('project0.payments_paymentid_seq', 3, true);
            project0       postgres    false    225            �
           2606    24790    car cars_pk 
   CONSTRAINT     N   ALTER TABLE ONLY project0.car
    ADD CONSTRAINT cars_pk PRIMARY KEY (carid);
 7   ALTER TABLE ONLY project0.car DROP CONSTRAINT cars_pk;
       project0         postgres    false    219            �
           2606    24777    user customers_pk 
   CONSTRAINT     W   ALTER TABLE ONLY project0."user"
    ADD CONSTRAINT customers_pk PRIMARY KEY (userid);
 ?   ALTER TABLE ONLY project0."user" DROP CONSTRAINT customers_pk;
       project0         postgres    false    218            �
           2606    24888    loan loan_pk 
   CONSTRAINT     P   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_pk PRIMARY KEY (loanid);
 8   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_pk;
       project0         postgres    false    227            �
           2606    24803    offer offers_pk 
   CONSTRAINT     T   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_pk PRIMARY KEY (offerid);
 ;   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_pk;
       project0         postgres    false    221            �
           2606    24801    payment payments_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_pk PRIMARY KEY (paymentid);
 ?   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_pk;
       project0         postgres    false    220            �
           2606    24889 
   car car_fk    FK CONSTRAINT     q   ALTER TABLE ONLY project0.car
    ADD CONSTRAINT car_fk FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 6   ALTER TABLE ONLY project0.car DROP CONSTRAINT car_fk;
       project0       postgres    false    219    218    2762            �
           2606    24894    loan loan_fk    FK CONSTRAINT     n   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_fk FOREIGN KEY (carid) REFERENCES project0.car(carid);
 8   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_fk;
       project0       postgres    false    219    2764    227            �
           2606    24899    loan loan_fk2    FK CONSTRAINT     t   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_fk2 FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 9   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_fk2;
       project0       postgres    false    218    2762    227            �
           2606    24850    offer offers_fk    FK CONSTRAINT     q   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_fk FOREIGN KEY (carid) REFERENCES project0.car(carid);
 ;   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_fk;
       project0       postgres    false    219    2764    221            �
           2606    24855    offer offers_fk2    FK CONSTRAINT     w   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_fk2 FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 <   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_fk2;
       project0       postgres    false    218    2762    221            �
           2606    24804    payment payments_fk    FK CONSTRAINT     z   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_fk FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 ?   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_fk;
       project0       postgres    false    2762    218    220            �
           2606    24824    payment payments_fk2    FK CONSTRAINT     v   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_fk2 FOREIGN KEY (carid) REFERENCES project0.car(carid);
 @   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_fk2;
       project0       postgres    false    2764    220    219            T   m   x�=�[
�0F�����R�	W��0Q*��x)��7����;�:F��Q��h��Tbտ��\4%�wΝ�m�_P�� �j�ԍ�*���U��P�K��Ϳ�ˌ�K�$�]�'\      \   (   x�3�450�32�42�30�4�4�45��37����� T�      V   K   x�34�4��J�M-���I,�4����KI�LLN�/J�4�0�34�2� J�%1����b�@F��q��qqq Hw$�      U   A   x�3�4202�50"N#S=#SN#ά���b����bΒ����D�������DNc.c�u��qqq hc0      S   r   x�u̻
�0����ai.s������&J�}\�tx������U1���\�}h\T$6���U6j!�����
1�P0��Z���c�x��oV�Pf���d���/���^Q�U�      .    _           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            `           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            a           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    24732    project0    SCHEMA        CREATE SCHEMA project0;
    DROP SCHEMA project0;
             postgres    false            �            1259    24739    car    TABLE     �   CREATE TABLE project0.car (
    carid integer NOT NULL,
    make character varying NOT NULL,
    model character varying NOT NULL,
    year character varying,
    status character varying NOT NULL,
    userid integer
);
    DROP TABLE project0.car;
       project0         postgres    false    7            �            1259    24780    cars_carid_seq    SEQUENCE     �   CREATE SEQUENCE project0.cars_carid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE project0.cars_carid_seq;
       project0       postgres    false    219    7            b           0    0    cars_carid_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE project0.cars_carid_seq OWNED BY project0.car.carid;
            project0       postgres    false    224            �            1259    24733    user    TABLE       CREATE TABLE project0."user" (
    userid integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    type character varying NOT NULL
);
    DROP TABLE project0."user";
       project0         postgres    false    7            �            1259    24748    customers_customerid_seq    SEQUENCE     �   CREATE SEQUENCE project0.customers_customerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE project0.customers_customerid_seq;
       project0       postgres    false    7    218            c           0    0    customers_customerid_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE project0.customers_customerid_seq OWNED BY project0."user".userid;
            project0       postgres    false    222            �            1259    24880    loan    TABLE       CREATE TABLE project0.loan (
    loanid integer NOT NULL,
    purchaseprice numeric(8,2) NOT NULL,
    interest numeric(8,2) NOT NULL,
    userid integer NOT NULL,
    carid integer NOT NULL,
    payments_remaining integer DEFAULT 60 NOT NULL,
    payment_amount numeric
);
    DROP TABLE project0.loan;
       project0         postgres    false    7            �            1259    24878    loan_loanid_seq    SEQUENCE     �   CREATE SEQUENCE project0.loan_loanid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE project0.loan_loanid_seq;
       project0       postgres    false    227    7            d           0    0    loan_loanid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE project0.loan_loanid_seq OWNED BY project0.loan.loanid;
            project0       postgres    false    226            �            1259    24745    offer    TABLE       CREATE TABLE project0.offer (
    offerid integer NOT NULL,
    userid integer NOT NULL,
    firstname character varying,
    lastname character varying,
    carid integer NOT NULL,
    make character varying,
    model character varying,
    amount numeric(8,2) NOT NULL
);
    DROP TABLE project0.offer;
       project0         postgres    false    7            �            1259    24766    offers_offerid_seq    SEQUENCE     �   CREATE SEQUENCE project0.offers_offerid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE project0.offers_offerid_seq;
       project0       postgres    false    221    7            e           0    0    offers_offerid_seq    SEQUENCE OWNED BY     L   ALTER SEQUENCE project0.offers_offerid_seq OWNED BY project0.offer.offerid;
            project0       postgres    false    223            �            1259    24742    payment    TABLE     S  CREATE TABLE project0.payment (
    paymentid integer NOT NULL,
    date date NOT NULL,
    amount numeric(8,2) NOT NULL,
    userid integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    make character varying NOT NULL,
    model character varying NOT NULL,
    carid integer NOT NULL
);
    DROP TABLE project0.payment;
       project0         postgres    false    7            �            1259    24791    payments_paymentid_seq    SEQUENCE     �   CREATE SEQUENCE project0.payments_paymentid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE project0.payments_paymentid_seq;
       project0       postgres    false    7    220            f           0    0    payments_paymentid_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE project0.payments_paymentid_seq OWNED BY project0.payment.paymentid;
            project0       postgres    false    225            �
           2604    24782 	   car carid    DEFAULT     k   ALTER TABLE ONLY project0.car ALTER COLUMN carid SET DEFAULT nextval('project0.cars_carid_seq'::regclass);
 :   ALTER TABLE project0.car ALTER COLUMN carid DROP DEFAULT;
       project0       postgres    false    224    219            �
           2604    24883    loan loanid    DEFAULT     n   ALTER TABLE ONLY project0.loan ALTER COLUMN loanid SET DEFAULT nextval('project0.loan_loanid_seq'::regclass);
 <   ALTER TABLE project0.loan ALTER COLUMN loanid DROP DEFAULT;
       project0       postgres    false    226    227    227            �
           2604    24768    offer offerid    DEFAULT     s   ALTER TABLE ONLY project0.offer ALTER COLUMN offerid SET DEFAULT nextval('project0.offers_offerid_seq'::regclass);
 >   ALTER TABLE project0.offer ALTER COLUMN offerid DROP DEFAULT;
       project0       postgres    false    223    221            �
           2604    24793    payment paymentid    DEFAULT     {   ALTER TABLE ONLY project0.payment ALTER COLUMN paymentid SET DEFAULT nextval('project0.payments_paymentid_seq'::regclass);
 B   ALTER TABLE project0.payment ALTER COLUMN paymentid DROP DEFAULT;
       project0       postgres    false    225    220            �
           2604    24750    user userid    DEFAULT     y   ALTER TABLE ONLY project0."user" ALTER COLUMN userid SET DEFAULT nextval('project0.customers_customerid_seq'::regclass);
 >   ALTER TABLE project0."user" ALTER COLUMN userid DROP DEFAULT;
       project0       postgres    false    222    218            T          0    24739    car 
   TABLE DATA               I   COPY project0.car (carid, make, model, year, status, userid) FROM stdin;
    project0       postgres    false    219   H       \          0    24880    loan 
   TABLE DATA               t   COPY project0.loan (loanid, purchaseprice, interest, userid, carid, payments_remaining, payment_amount) FROM stdin;
    project0       postgres    false    227   �       V          0    24745    offer 
   TABLE DATA               c   COPY project0.offer (offerid, userid, firstname, lastname, carid, make, model, amount) FROM stdin;
    project0       postgres    false    221   �       U          0    24742    payment 
   TABLE DATA               m   COPY project0.payment (paymentid, date, amount, userid, firstname, lastname, make, model, carid) FROM stdin;
    project0       postgres    false    220   X       S          0    24733    user 
   TABLE DATA               V   COPY project0."user" (userid, firstname, lastname, email, password, type) FROM stdin;
    project0       postgres    false    218   �       g           0    0    cars_carid_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('project0.cars_carid_seq', 7, true);
            project0       postgres    false    224            h           0    0    customers_customerid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('project0.customers_customerid_seq', 12, true);
            project0       postgres    false    222            i           0    0    loan_loanid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('project0.loan_loanid_seq', 8, true);
            project0       postgres    false    226            j           0    0    offers_offerid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('project0.offers_offerid_seq', 21, true);
            project0       postgres    false    223            k           0    0    payments_paymentid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('project0.payments_paymentid_seq', 3, true);
            project0       postgres    false    225            �
           2606    24790    car cars_pk 
   CONSTRAINT     N   ALTER TABLE ONLY project0.car
    ADD CONSTRAINT cars_pk PRIMARY KEY (carid);
 7   ALTER TABLE ONLY project0.car DROP CONSTRAINT cars_pk;
       project0         postgres    false    219            �
           2606    24777    user customers_pk 
   CONSTRAINT     W   ALTER TABLE ONLY project0."user"
    ADD CONSTRAINT customers_pk PRIMARY KEY (userid);
 ?   ALTER TABLE ONLY project0."user" DROP CONSTRAINT customers_pk;
       project0         postgres    false    218            �
           2606    24888    loan loan_pk 
   CONSTRAINT     P   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_pk PRIMARY KEY (loanid);
 8   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_pk;
       project0         postgres    false    227            �
           2606    24803    offer offers_pk 
   CONSTRAINT     T   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_pk PRIMARY KEY (offerid);
 ;   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_pk;
       project0         postgres    false    221            �
           2606    24801    payment payments_pk 
   CONSTRAINT     Z   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_pk PRIMARY KEY (paymentid);
 ?   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_pk;
       project0         postgres    false    220            �
           2606    24889 
   car car_fk    FK CONSTRAINT     q   ALTER TABLE ONLY project0.car
    ADD CONSTRAINT car_fk FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 6   ALTER TABLE ONLY project0.car DROP CONSTRAINT car_fk;
       project0       postgres    false    219    218    2762            �
           2606    24894    loan loan_fk    FK CONSTRAINT     n   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_fk FOREIGN KEY (carid) REFERENCES project0.car(carid);
 8   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_fk;
       project0       postgres    false    219    2764    227            �
           2606    24899    loan loan_fk2    FK CONSTRAINT     t   ALTER TABLE ONLY project0.loan
    ADD CONSTRAINT loan_fk2 FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 9   ALTER TABLE ONLY project0.loan DROP CONSTRAINT loan_fk2;
       project0       postgres    false    218    2762    227            �
           2606    24850    offer offers_fk    FK CONSTRAINT     q   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_fk FOREIGN KEY (carid) REFERENCES project0.car(carid);
 ;   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_fk;
       project0       postgres    false    219    2764    221            �
           2606    24855    offer offers_fk2    FK CONSTRAINT     w   ALTER TABLE ONLY project0.offer
    ADD CONSTRAINT offers_fk2 FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 <   ALTER TABLE ONLY project0.offer DROP CONSTRAINT offers_fk2;
       project0       postgres    false    218    2762    221            �
           2606    24804    payment payments_fk    FK CONSTRAINT     z   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_fk FOREIGN KEY (userid) REFERENCES project0."user"(userid);
 ?   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_fk;
       project0       postgres    false    2762    218    220            �
           2606    24824    payment payments_fk2    FK CONSTRAINT     v   ALTER TABLE ONLY project0.payment
    ADD CONSTRAINT payments_fk2 FOREIGN KEY (carid) REFERENCES project0.car(carid);
 @   ALTER TABLE ONLY project0.payment DROP CONSTRAINT payments_fk2;
       project0       postgres    false    2764    220    219           