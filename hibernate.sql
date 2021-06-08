create database hibernate;
use hibernate;
create table giaovu
(
	magiaovu char(8),
    hoten varchar(50) charset utf8mb4,
    diachi varchar(100) charset utf8mb4,
    sdt char(10),
    gioi varchar(3) charset utf8mb4,
    ngaysinh datetime,
    primary key (magiaovu)
);
create table taikhoangiaovu
(
	magiaovu char(8),
	taikhoan varchar(30),
	matkhau varchar(30),
	primary key (taikhoan)
);
create table sinhvien
(
	masinhvien char(8),
    hoten varchar(50) charset utf8mb4,
    diachi varchar(100) charset utf8mb4,
    sdt char(10),
    gioi varchar(3) charset utf8mb4,
    ngaysinh datetime,
    khoa varchar(10),
    primary key (masinhvien)
);
create table taikhoansinhvien
(
	masinhvien char(8),
    taikhoan char(30),
    matkhau char(30),
    primary key (taikhoan)
);
create table lop
(
	id int(11) not null auto_increment,
	tongsinhvien int,
    tongsinhviennu int,
	tongsinhviennam int,
    hocki char(3),
    namhoc char(9),
    mamon char(5),
    mahocphan char(6),
    primary key (id, hocki, namhoc, mamon, mahocphan)
);
create table mon
(
	mamon char(5),
    sotinchi int,
    tenmon varchar(50) charset utf8mb4,
    primary key (mamon)
);
create table hocphan
(
	mahocphan char(6),
    mamon char(5),
    sotinchi int, 
    tenhocphan varchar(50) charset utf8mb4,
    giangvienlythuyet char(8),
    phonghoc varchar(50) charset utf8mb4,
    ngayhoc varchar(8) charset utf8mb4,
    cahoc varchar(11),
    soslottoida int,
    primary key (mahocphan, mamon)
);
create table hocki
(
	hocki char(3),
    namhoc char(9),
    thoigianbatdau datetime,
    thoigianketthuc datetime,
    hockihientai boolean,
    primary key (hocki, namhoc)
);
create table kidangkyhocphan
(
	hocki char(3),
    namhoc char(9),
	thoigianbatdau datetime,
    thoigianketthuc datetime,
    primary key (hocki, namhoc, thoigianbatdau)
);
create table mon_hocki
(
	mamon char(5),
    hocki char(3),
    namhoc char(9),
    primary key (mamon, hocki, namhoc)
);
create table hocphan_dkhp
(
	mahocphan char(6),
    mamon char(5),
    hocki char(3),
    namhoc char(9),
    thoigianbatdau datetime,
    primary key (mahocphan, mamon, hocki, namhoc)
);
create table sinhvien_lop
(
	masinhvien char(8),
    id int,
    hocki char(3),
    namhoc char(9),
    mamon char(5),
    mahocphan char(6),
    primary key (masinhvien, id)
);
create table sinhvien_hocphan
(
	masinhvien char(8),
    hocki char(3),
    namhoc char(9),
    mamon char(5),
    mahocphan char(6),
    thoigiandangki datetime,
    primary key (masinhvien, hocki, namhoc, mamon)
);

alter table taikhoangiaovu
add constraint fk_tk_gv
foreign key (magiaovu)
references giaovu(magiaovu);

alter table taikhoansinhvien
add constraint fk_tk_sv
foreign key (masinhvien)
references sinhvien(masinhvien);

alter table lop
add constraint fk_lop_mon_hocki
foreign key (mamon, hocki, namhoc)
references mon_hocki(mamon, hocki, namhoc);

alter table lop
add constraint fk_lop_hocphan
foreign key (mahocphan, mamon)
references hocphan(mahocphan, mamon);

alter table hocphan
add constraint fk_hocphan_mon
foreign key (mamon)
references mon(mamon);

alter table kidangkyhocphan
add constraint fk_dkhp_hocki
foreign key (hocki, namhoc)
references hocki(hocki, namhoc);

alter table mon_hocki
add constraint fk_m_ma
foreign key (mamon)
references mon(mamon);

alter table mon_hocki
add constraint fk_m_hk
foreign key (hocki, namhoc)
references hocki(hocki, namhoc);

alter table hocphan_dkhp
add constraint fk_hpdk_hp
foreign key (mamon, mahocphan)
references hocphan(mamon, mahocphan);

alter table hocphan_dkhp
add constraint fk_hpdk_monhk
foreign key (mamon, hocki, namhoc)
references mon_hocki(mamon, hocki, namhoc);

alter table hocphan_dkhp
add constraint fk_hpdk_kidki
foreign key (hocki, namhoc, thoigianbatdau)
references kidangkyhocphan(hocki, namhoc, thoigianbatdau);

alter table sinhvien_lop
add constraint fk_svl_svhp
foreign key (masinhvien, hocki, namhoc, mamon)
references sinhvien_hocphan(masinhvien, hocki, namhoc, mamon);

alter table sinhvien_lop
add constraint fk_svl_l
foreign key (id, hocki, namhoc, mamon, mahocphan)
references lop(id, hocki, namhoc, mamon, mahocphan);

alter table sinhvien_hocphan
add constraint fk_svhp_sv
foreign key (masinhvien)
references sinhvien(masinhvien);

alter table sinhvien_hocphan
add constraint fk_svhp_hp
foreign key (mahocphan, mamon, hocki, namhoc)
references hocphan_dkhp(mahocphan, mamon, hocki, namhoc);

alter table giaoVu
add constraint c_gioi_gv 
check(gioi in ('Nam', 'Nữ'));

alter table sinhVien
add constraint c_gioi_sv
check(gioi in ('Nam', 'Nữ'));

alter table hocphan
add constraint c_ngay_hp
check(ngayhoc in ('Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm', 'Thứ sáu', 'Thứ bảy', 'Chủ nhật'));

alter table hocphan
add constraint c_ca_hp
check(cahoc in ('07:30-09:30', '09:30-11:30', '13:30-15:30', '15:30-17:30'));

alter table hocphan
add constraint c_tc_hp
check(sotinchi>0);

alter table mon
add constraint c_tc_m
check(sotinchi>0);

alter table hocki
add constraint c_ten_hk
check(hocki in ('HK1', 'HK2', 'HK3'));

insert into giaovu values ('00000001', 'Trần Văn Cao', '11 An Bình, Phường 10, Quận 5, TPHCM', '0772341827', 'Nam', '1980-12-10');
insert into giaovu values ('00000002', 'Nguyễn Thị Bạch', '93 Lý Thường Kiệt, Phường 10, Quận 5, TPHCM', '0704928192', 'Nữ', '1979-10-21');
insert into giaovu values ('00000003', 'Nguyễn Văn Thơm', '93 Bùi Tư Toàn, Phường 04, Quận Tân Bình, TPHCM', '0366718272', 'Nam', '1985-7-25');

insert into taikhoangiaovu values ('00000001','00000001','00000001');
insert into taikhoangiaovu values ('00000002','00000002','00000002');
insert into taikhoangiaovu values ('00000003','00000003','00000003');

insert into sinhvien values ('19120001', 'Trần Chí Thiện', '82 Hoàng Diệu 2, Phường Tam Bình, Quận Thủ Đức , TPHCM', '0704582473', 'Nam', '2001-12-20', 'CNTT');
insert into sinhvien values ('19120426', 'Nguyễn Trần Bảo Nghi', '74 Đường số 13A, Phường Bình Trị Đông B, Quận Bình Tân, TPHCM', '0772618246', 'Nữ', '2000-10-21', 'CNTT');
insert into sinhvien values ('19120482', 'Trần Văn Chí', '78 Vĩnh Lộc, Phường Bình Hưng Hòa, Quận Bình Tân, TPHCM', '0275849182', 'Nam', '1999-7-19', 'CNTT');
insert into sinhvien values ('19120481', 'Nguyễn Kiều Trinh', '57 Đường D5, Phường 22, Quận Bình Thạnh, TPHCM', '0366471928', 'Nữ', '2001-4-30', 'CNTT');

insert into taikhoansinhvien values ('19120001', '19120001', '19120001');
insert into taikhoansinhvien values ('19120426', '19120426', '19120426');
insert into taikhoansinhvien values ('19120482', '19120482', '19120482');
insert into taikhoansinhvien values ('19120481', '19120481', '19120481');

insert into mon values ('00001', 4, 'Toán học tổ hợp');
insert into mon values ('00002', 4, 'Kĩ thuật lập trình');
insert into mon values ('00003', 3, 'Toán rời rạc');
insert into mon values ('00004', 4, 'Cơ sở dữ liệu');
insert into mon values ('00005', 2, 'Sinh học tế bào');
insert into mon values ('00006', 4, 'Anh văn 4');
insert into mon values ('00007', 4, 'Cấu trúc dữ liệu');
insert into mon values ('00008', 2, 'Con người và môi trường');
insert into mon values ('00009', 4, 'Đại số tuyến tính');

insert into hocphan values ('000011','00001', 4, 'Toán học tổ hợp 19/1', '00000005', 'E305', 'Thứ bảy', '07:30-09:30', 120);
insert into hocphan values ('000012', '00001', 4, 'Toán học tổ hợp 19/2', '00000004', 'E205', 'Thứ hai', '07:30-09:30', 120);
insert into hocphan values ('000021', '00002', 4, 'Kĩ thuật lập trình 19/1', '00000001', 'F106', 'Thứ hai', '07:30-09:30', 100);
insert into hocphan values ('000022', '00002', 4, 'Kĩ thuật lập trình 19/2', '00000003', 'F206', 'Thứ ba', '07:30-09:30', 100);
insert into hocphan values ('000031', '00003', 4, 'Cơ sở dữ liệu 20/1', '00000001', 'F207', 'Thứ tư', '13:30-15:30',100);
insert into hocphan values ('000032', '00003', 4, 'Cơ sở dữ liệu 20/2', '00000002', 'F204', 'Thứ tư', '07:30-09:30',100);
insert into hocphan values ('000041', '00004', 3, 'Toán rời rạc 20/1','00000010', 'E106', 'Thứ năm', '09:30-11:30', 120);
insert into hocphan values ('000042', '00004', 3, 'Toán rời rạc 20/2','00000011', 'E104', 'Thứ tư', '09:30-11:30', 120);
insert into hocphan values ('000051', '00005', 2, 'Sinh học tế bào 19/1', '00000021', 'F205', 'Thứ sáu', '09:30-11:30', 70);
insert into hocphan values ('000052', '00005', 2, 'Sinh học tế bào 19/2', '00000021', 'F205', 'Thứ sáu', '13:30-15:30', 70);
insert into hocphan values ('000061', '00006', 4, 'Anh văn 4.1', '00000030', 'NDDH4.5', 'Thứ hai', '13:30-15:30', 40);
insert into hocphan values ('000062', '00006', 4, 'Anh văn 4.2', '00000031', 'NDDH4.5', 'Thứ hai', '15:30-17:30', 40);
insert into hocphan values ('000071', '00007', 4, 'Cấu trúc dữ liệu 19/1', '00000001', 'E204', 'Thứ ba', '13:30-15:30', 120);
insert into hocphan values ('000072', '00007', 4, 'Cấu trúc dữ liệu 19/2',  '00000001', 'E204', 'Thứ ba', '15:30-17:30', 120);
insert into hocphan values ('000081', '00008', 2, 'Con người và môi trường 20/1', '10000001', 'E203', 'Thứ năm', '07:30-09:30', 70);
insert into hocphan values ('000082', '00008', 2, 'Con người và môi trường 20/2', '10000002', 'E201', 'Thứ năm', '07:30-09:30', 70);
insert into hocphan values ('000091', '00009', 4, 'Đại số tuyến tính 19/1', '00000005', 'F106', 'Thứ bảy' , '09:30-11:30', 100);
insert into hocphan values ('000092', '00009', 4, 'Đại số tuyến tính 19/2', '00000004', 'F206', 'Thứ bảy' , '15:30-17:30', 100);

insert into hocki values ('hk1', '2019-2020', '2019-8-15', '2020-2-3', false);
insert into hocki values ('hk2', '2019-2020', '2020-2-3', '2020-6-15', false);
insert into hocki values ('hk1', '2020-2021', '2020-8-1', '2021-2-20', false);
insert into hocki values ('hk2', '2020-2021', '2021-2-20', '2021-7-3', false);

insert into mon_hocki values ('00009', 'hk2', '2020-2021');
insert into mon_hocki values ('00008', 'hk2', '2020-2021');
insert into mon_hocki values ('00007', 'hk2', '2020-2021');
insert into mon_hocki values ('00006', 'hk2', '2020-2021');
insert into mon_hocki values ('00005', 'hk2', '2020-2021');
insert into mon_hocki values ('00004', 'hk2', '2020-2021');
insert into mon_hocki values ('00003', 'hk2', '2020-2021');
insert into mon_hocki values ('00002', 'hk2', '2020-2021');
insert into mon_hocki values ('00001', 'hk2', '2020-2021');
insert into mon_hocki values ('00001', 'hk1', '2019-2020');
insert into mon_hocki values ('00002', 'hk2', '2019-2020');
insert into mon_hocki values ('00002', 'hk1', '2020-2021');
insert into mon_hocki values ('00003', 'hk2', '2019-2020');

insert into kidangkyhocphan values ('hk1', '2019-2020', '2019-7-29 9:00:00', '2019-8-1 21:00:00');
insert into kidangkyhocphan values ('hk2', '2019-2020', '2020-1-20 9:00:00', '2020-1-22 21:00:00');
insert into kidangkyhocphan values ('hk1', '2020-2021', '2020-7-25 9:00:00', '2020-7-27 21:00:00');
insert into kidangkyhocphan values ('hk2', '2020-2021', '2021-2-2 9:00:00', '2021-2-5 21:00:00');

insert into hocphan_dkhp values ('000011', '00001', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000012', '00001', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000021', '00002', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000022', '00002', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000031', '00003', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000032', '00003', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000041', '00004', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000042', '00004', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000051', '00005', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000052', '00005', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000061', '00006', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000062', '00006', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000071', '00007', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000072', '00007', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000081', '00008', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000082', '00008', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000091', '00009', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000092', '00009', 'hk2', '2020-2021', '2021-2-2 9:00:00');
insert into hocphan_dkhp values ('000011', '00001', 'hk1', '2019-2020', '2019-7-29 9:00:00');
insert into hocphan_dkhp values ('000012', '00001', 'hk1', '2019-2020', '2019-7-29 9:00:00');
insert into hocphan_dkhp values ('000021', '00002', 'hk2', '2019-2020', '2020-1-20 9:00:00');
insert into hocphan_dkhp values ('000022', '00002', 'hk2', '2019-2020', '2020-1-20 9:00:00');
insert into hocphan_dkhp values ('000031', '00003', 'hk2', '2019-2020', '2020-1-20 9:00:00');
insert into hocphan_dkhp values ('000032', '00003', 'hk2', '2019-2020', '2020-1-20 9:00:00');
insert into hocphan_dkhp values ('000021', '00002', 'hk1', '2020-2021', '2020-7-25 9:00:00');
insert into hocphan_dkhp values ('000022', '00002', 'hk1', '2020-2021', '2020-7-25 9:00:00');

insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00001', '000011');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00001', '000012');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00002', '000021');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00002', '000022');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00003', '000031');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00003', '000032');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00004', '000041');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00004', '000042');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00005', '000051');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00005', '000052');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00006', '000061');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00006', '000062');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00007', '000071');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00007', '000072');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00008', '000081');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00008', '000082');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00009', '000091');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2020-2021', '00009', '000092');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk1', '2019-2020', '00001', '000011');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk1', '2019-2020', '00001', '000012');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2019-2020', '00002', '000021');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2019-2020', '00002', '000022');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2019-2020', '00003', '000031');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk2', '2019-2020', '00003', '000032');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk1', '2020-2021', '00002', '000021');
insert into lop (tongsinhvien, tongsinhviennu, tongsinhviennam, hocki, namhoc, mamon, mahocphan) values (null, null, null, 'hk1', '2020-2021', '00002', '000022');

insert into sinhvien_hocphan values ('19120001', 'hk1', '2019-2020', '00001', '000012', '2019-7-29 10:00:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00001', '000011', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00002', '000021', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00003', '000031', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00004', '000041', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00005', '000051', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00006', '000061', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00007', '000071', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00008', '000081', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120001', 'hk2', '2020-2021', '00009', '000091', '2021-2-2 9:30:00');
insert into sinhvien_hocphan values ('19120426', 'hk2', '2020-2021', '00009', '000092', '2021-2-2 9:31:00');
insert into sinhvien_hocphan values ('19120426', 'hk1', '2019-2020', '00001', '000011', '2021-2-2 9:31:00');
insert into sinhvien_hocphan values ('19120481' ,'hk2', '2019-2020', '00002', '000022', '2020-1-21 7:00:00');
insert into sinhvien_hocphan values ('19120481' ,'hk1', '2020-2021', '00002', '000022', '2020-7-25 11:00:00');

insert into sinhvien_lop values ('19120001', '20', 'hk1', '2019-2020', '00001', '000012');
insert into sinhvien_lop values ('19120001', '1', 'hk2', '2020-2021', '00001', '000011');
insert into sinhvien_lop values ('19120001', '3', 'hk2', '2020-2021', '00002', '000021');
insert into sinhvien_lop values ('19120001', '5', 'hk2', '2020-2021', '00003', '000031');
insert into sinhvien_lop values ('19120001', '7', 'hk2', '2020-2021', '00004', '000041');
insert into sinhvien_lop values ('19120001', '9', 'hk2', '2020-2021', '00005', '000051');
insert into sinhvien_lop values ('19120001', '11', 'hk2', '2020-2021', '00006', '000061');
insert into sinhvien_lop values ('19120001', '13', 'hk2', '2020-2021', '00007', '000071');
insert into sinhvien_lop values ('19120001', '15', 'hk2', '2020-2021', '00008', '000081');
insert into sinhvien_lop values ('19120001', '17', 'hk2', '2020-2021', '00009', '000091');
insert into sinhvien_lop values ('19120426', '18', 'hk2', '2020-2021', '00009', '000092');
insert into sinhvien_lop values ('19120426', '19', 'hk1', '2019-2020', '00001', '000011');
insert into sinhvien_lop values ('19120481', '22', 'hk2', '2019-2020', '00002', '000022');
insert into sinhvien_lop values ('19120481', '26', 'hk1', '2020-2021', '00002', '000022');

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 1
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 1
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 1;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 2
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 2
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 2;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 3
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 3
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 3;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 4
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 4
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 4;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 5
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 5
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 5;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 6
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 6
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 6;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 7
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 7
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 7;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 8
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 8
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 8;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 9
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 9
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 9;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 10
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 10
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 10;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 11
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 11
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 11;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 12
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 12
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 12;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 13
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 13
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 13;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 14
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 14
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 14;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 15
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 15
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 15;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 16
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 16
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 16;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 17
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 17
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 17;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 18
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 18
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 18;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 19
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 19
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 19;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 20
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 20
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 20;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 21
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 21
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 21;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 22
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 22
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 22;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 23
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 23
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 23;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 24
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 24
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 24;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 25
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 25
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 25;

update lop set tongsinhviennu=(select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 26
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nữ'
),
tongsinhviennam = (select count(*)
from sinhvien_lop svl, sinhvien sv
where svl.id = 26
and svl.masinhvien = sv.masinhvien
and sv.gioi = 'Nam'
),
tongsinhvien = tongsinhviennu + tongsinhviennam
where id = 26;