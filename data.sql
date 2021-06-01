create database dean
use dean
create table giaovu
(
	magv char(8),
    hoten VARCHAR(50) CHARSET utf8mb4,
    diachi VARCHAR(100) CHARSET utf8mb4,
    gioi VARCHAR(3) CHARSET utf8mb4,
    ngaysinh datetime,
    primary key(magv)
)

create table taikhoangv
(
	magv char(8),
    tk char(20),
    mk char(20),
    primary key(magv)
)

create table sinhvien
(
	masv char(8),
    hoten VARCHAR(50) CHARSET utf8mb4,
    diachi VARCHAR(100) CHARSET utf8mb4,
    ngaysinh datetime,
    gioi VARCHAR(100) CHARSET utf8mb4,
    khoahoc varchar(10),
    cmnd char(12),
    primary key(masv, cmnd)
)

create table taikhoansv
(
	masv char(8),
    cmnd char(12),
    tk char(20),
    mk char(20),
    primary key(cmnd)
)

create table hocphan
(
	mahp char(10),
	hocki char(3),
    namhoc varchar(10),
    tenhp VARCHAR(50) CHARSET utf8mb4,
    soslottoida int,
    ngayhoc VARCHAR(10) CHARSET utf8mb4,
    cahoc char(11),
    phonghoc VARCHAR(20) CHARSET utf8mb4,
    sotc int,
    giaovienlt char(8),
    primary key(mahp, hocki, namhoc)
)

create table thoigiandkhp
(
    thoigianbatdau datetime,
    thoigianketthuc datetime,
    hocki char(3),
    namhoc varchar(10),
    primary key (thoigianbatdau, hocki, namhoc)
)

create table hocki
(
	tenhk char(3),
	namhoc varchar(10),
	ngaybatdau datetime,
    ngayketthuc datetime,
	hockihientai bool,
    primary key (tenhk, namhoc)
)

create table lop
(
	sosv int,
    sosvnu int,
    sosvnam int,
    tenlop VARCHAR(50) CHARSET utf8mb4,
    malop char(8),
    hocki char(3),
    namhoc varchar(10),
    primary key(malop, hocki, namhoc)
)

create table sinhvien_lop
(
	masv char(8),
    cmnd char(12),
    malop char(8),
    hocki char(3),
    namhoc varchar(10),
    primary key(cmnd, malop, hocki, namhoc)
)

create table dkhp
(
	masv char(8),
    cmnd char(12),
    mahp char(10),
    hocki char(3),
    namhoc varchar(10),
    thoigiandki datetime,
    primary key (cmnd, mahp, hocki, namhoc)
)

alter table taikhoangv
add constraint fk_taikhoan_gv
foreign key (magv)
references giaovu(magv)

alter table taikhoansv
add constraint fk_taikhoan_sv
foreign key (masv, cmnd)
references sinhvien(masv, cmnd)

alter table hocphan
add constraint fk_hp_hocki
foreign key (hocki, namhoc)
references hocki(tenhk, namhoc)

alter table thoigiandkhp
add constraint fk_dk_hk
foreign key (hocki, namhoc)
references hocki(tenhk, namhoc)

alter table lop
add constraint fk_lop_hocki
foreign key (hocki, namhoc)
references hocki(tenhk, namhoc)

alter table sinhvien_lop
add constraint fk_svlop_sv
foreign key (masv, cmnd)
references sinhvien(masv, cmnd)

alter table sinhvien_lop
add constraint fk_svlop_lop
foreign key (malop, hocki, namhoc)
references lop(malop, hocki, namhoc)

alter table dkhp
add constraint fk_dkhp_sv
foreign key (masv, cmnd)
references sinhvien(masv, cmnd)

alter table dkhp
add constraint fk_dkhp_hp
foreign key (mahp, hocki, namhoc)
references hocphan(mahp, hocki, namhoc)

alter table giaovu
add constraint c_gioi_gv 
check(gioi in ('Nam', 'Nữ'))

alter table sinhvien
add constraint c_gioi_sv
check(gioi in ('Nam', 'Nữ'))

alter table hocphan
add constraint c_ngay_hp
check(ngayhoc in ('Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm', 'Thứ sáu', 'Thứ bảy', 'Chủ nhật'))

alter table hocphan
add constraint c_ca_hp
check(cahoc in ('07:30-09:30', '09:30-11:30', '13:30-15:30', '15:30-17:30'))

alter table hocphan
add constraint c_tc_hp
check(sotc>0)

alter table hocki
add constraint c_ten_hk
check(tenhk in ('HK1', 'HK2', 'HK3'))

insert into giaovu values ('00000001', 'Nguyễn Văn Chữ', 'Nguyễn Văn Bảo, Phường 4, Gò Vấp, TPHCM', 'Nam', 19-02-1996)
insert into giaovu values ('00000002', 'Trần Thị An', '58 Phạm Viết Chánh, P.Nguyễn Cư Trinh, Quận 1, TPHCM', 'Nữ', 20-10-1970)
insert into giaovu values ('00000003', 'Trần Văn Chiến', '60 Phạm Viết Chánh, P.Nguyễn Cư Trinh, Quận 1, TPHCM', 'Nam', 15-7-1960)

insert into taikhoangv values ('00000001', 'giaovu1', 'giaovu1')
insert into taikhoangv values ('00000002', 'giaovu2', 'giaovu2')
insert into taikhoangv values ('00000003', 'giaovu3', 'giaovu3')

insert into sinhvien
values ('19120001', 'Trần Thị Bạch', 'Gò Vấp, TPHCM', 19-2-2001, 'Nữ', 'K2019', '123456789123')
insert into sinhvien
values ('19120201', 'Trần Văn Thắng', '57 Lê Lai, Da Kao, Quận 1, TPHCM', 17-5-2000, 'Nam', 'K2018', '281749276201')
insert into sinhvien
values ('19120269', 'Nguyễn Thị Kiều Trinh', '62 Nguyễn Trãi, Phường 01, Quận 5, TPHCM', 17-5-2000, 'Nam', 'K2018', '472836291758')

insert into taikhoansv
values ('19120001','123456789123', 'sv2', 'sv2')
insert into taikhoansv
values ('19120201','281749276201', 'sv1', 'sv1')
insert into taikhoansv
values ('19120269','472836291758', 'sv3', 'sv3')

insert into hocki values ('hk1', '2019-2020', 10-8-2019, 14-2-2020, false)
insert into hocki values ('hk2', '2019-2020', 1-3-2020, 15-6-2020, false)
insert into hocki values ('hk1', '2020-2021', 1-9-2020, 10-3-2021, false)
insert into hocki values ('hk2', '2020-2021', 20-3-2020, 15-7-2021, true)

insert into hocphan values ('0000000001', 'hk2', '2019-2020', 'Toán tổ hợp', 120, 'thứ hai', '07:30-09:30', 'E302', 1, '00000002')
insert into hocphan values ('0000000001', 'hk1', '2019-2020', 'Toán rời rạc', 130, 'thứ ba', '07:30-09:30', 'E302', 1, '00000002')
insert into hocphan values ('0000000001', 'hk2', '2020-2021', 'LTUD Java', 120, 'thứ năm', '09:30-11:30', 'E302', 1, '00000006')

insert into thoigiandkhp values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk1', '2019-2020')
insert into thoigiandkhp values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk1', '2019-2020')
insert into thoigiandkhp values ('2021-02-12 7:20:50', '2021-02-23 9:00:01', 'hk1', '2019-2020')

insert into lop values (120, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk1', '2019-2020')
insert into lop values (100, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk1', '2019-2020')
insert into lop values (100, (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nữ'), (select count(*) from sinhvien sv, sinhvien_lop svl where svl.cmnd=sv.cmnd and sv.gioi='nam'), 'Toán', '12412412', 'hk1', '2019-2020')

insert into sinhvien_lop values ('19120001','123456789123', '12412412', 'hk1', '2019-2020')
insert into sinhvien_lop values ('19120201','281749276201', '12412412', 'hk1', '2019-2020')
insert into sinhvien_lop values ('19120269','472836291758', '12412412', 'hk1', '2019-2020')

insert into dkhp values ('19120001','123456789123', '0000000001', 'hk2', '2019-2020', null)
insert into dkhp values ('19120001','123456789123', '0000000001', 'hk1', '2019-2020', null)
insert into dkhp values ('19120201','281749276201', '0000000001', 'hk2', '2020-2021', null)