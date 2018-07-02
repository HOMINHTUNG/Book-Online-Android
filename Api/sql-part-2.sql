--///////////////////////////////////////
--Tác Giả Trigger
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('SA_MX',10,N'Số sách tối đa cho phép mượn')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('TG_ID',1,N'Giá trị tự động tăng Tác Giả')
go
create trigger TacGia_Incre
on TacGia
instead of insert
as
begin
	Declare @MaTacGia       char (5) 
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='TG_ID')
	Declare @TenTacGia  NVARCHAR (50) =(select TenTacGia from inserted)
	
	set @MaTacGia='TG'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)

	Insert into TacGia values (@MaTacGia,@TenTacGia)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='TG_ID'
end
go
--///////////////////////////////////////
--Thể Loại Trigger
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('TL_ID',1,N'Giá trị tự động tăng Thể Loại')
go
create trigger TheLoai_Incre
on TheLoai
instead of insert
as
begin
	Declare @MaTheLoai       CHAR (5) 
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='TL_ID')
	Declare @TenTheLoai  NVARCHAR (50) =(select TenTheLoai from inserted)
	
	set @MaTheLoai='TL'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)

	Insert into TheLoai values (@MaTheLoai,@TenTheLoai)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='TL_ID'
end
go
go
--///////////////////////////////////////
--Nhà Xuất Bản Trigger
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('NXBID',1,N'Giá trị tự động tăng Nhà Xuất Bản')
go
create trigger NhaXuatBan_Incre
on NhaXuatBan
instead of insert
as
begin
	Declare @MaNXB       char (5) 
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='NXBID')
	Declare @TenNXB  NVARCHAR (50) =(select TenNhaXuatBan from inserted)
	
	set @MaNXB='NXB'+REPLICATE('0',2-LEN(@ID))+Convert(varchar(2),@ID)

	Insert into NhaXuatBan values (@MaNXB,@TenNXB)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='NXBID'
end
go
--///////////////////////////////////////
--Sach
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('Sa_ID',1,N'Giá trị tự động tăng Sách')
go
create trigger Sach_Incre
on Sach
instead of insert
as
begin
	Declare @IDSach    char (5) 
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='SA_ID')
    Declare @IDTacGia    char (5)  =(select IDTacGia from inserted)
    Declare @IDNhaXuatBan char (5)   =(select IDNhaXuatBan from inserted)
    Declare @IDTheLoai    char (5)   =(select IDTheLoai from inserted)
    Declare @TenSach      NVARCHAR (50)  =(select TenSach from inserted)
    Declare @HinhAnh      VARCHAR (100)   =(select HinhAnh from inserted)
    Declare @MoTa      NVARCHAR (100)   =(select MoTa from inserted)
    Declare @NamXuatBan  int  = (select NamXuatBan from inserted)
    Declare @TriGia      Decimal(9,0) =(select TriGia from inserted)
	Declare @NgayNhapSach DateTime  =Getdate()
	Declare @SoLuong Integer =(select SoLuong from inserted)
	Declare @SoLuongTon Integer =(select SoLuongTon from inserted)
	
	set @IDSach='SA'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)

	insert into Sach(IDSach,IDTheLoai,IDTacGia,IDNhaXuatBan,TenSach,HinhAnh,NamXuatBan,SoLuong,SoLuongTon,TriGia,NgayNhapSach,MoTa) values (@IDSach,@IDTheLoai,@IDTacGia,@IDNhaXuatBan,@TenSach,@HinhAnh,@NamXuatBan,@SoLuong,@SoLuongTon,@TriGia,@NgayNhapSach,@MoTa)
 	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='SA_ID'
end
go



--///////////////////////////////////////
--Chuc Vu
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('CV_ID',1,N'Gía trị tự động tăng Chuc Vu')
go
create Trigger ChucVu_Incre
on ChucVu
instead of insert
as
begin
	Declare @IDChucVu       CHAR (5) 
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='CV_ID')
	Declare @TenChucVu  NVARCHAR (50) =(select TenChucVu from inserted)
	
	set @IDChucVu='CV'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)

	Insert into ChucVu values (@IDChucVu,@TenChucVu)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='CV_ID'
end
go


--///////////////////////////////////////
--NhanVien
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('NV_ID',1,N'Gía trị tự động tăng Nhân Viên')
go
create Trigger NhanVien_Incre
on NhanVien
instead of insert
as
begin
	Declare @IDNhanVien  VARCHAR (5)
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='NV_ID')
    Declare @TenNhanVien NVARCHAR (50)  =(select TenNhanVien from inserted)
    Declare @GioiTinh    INT            =(select GioiTinh from inserted)
    Declare @DiaChi      NVARCHAR (100) =(select DiaChi from inserted)
    Declare @SoDienThoai VARCHAR (12)   =(select SoDienThoai from inserted)
    Declare @Email       NVARCHAR (50)  =(select Email from inserted)
    Declare @CMND        VARCHAR (11)   =(select CMND from inserted)
    Declare @NgayVaoLam      DATETIME   =(select NgayVaoLam from inserted)
    Declare @MatKhau     VARCHAR (MAX)   =(select MatKhau from inserted)
    Declare @IDChucVu      NVARCHAR (5)  =(select IDChucVu from inserted)

	set @IDNhanVien='NV'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)
	insert into NhanVien(IDNhanVien,IDChucVu,TenNhanVien,GioiTinh,DiaChi,SoDienThoai,Email,CMND,NgayVaoLam,MatKhau)  values(@IDNhanVien,@IDChucVu,@TenNhanVien,@GioiTinh,@DiaChi,@SoDienThoai,@Email,@CMND,@NgayVaoLam,@MatKhau) 
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='NV_ID'
end

go
--///////////////////////////////////////
--Doc Gia
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('DG_ID',1,N'Gía trị tự động tăng Doc Gia')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('DAYGH',180,N'Ngay Gia Han Cho Moi Doc Gia')
go
create Trigger DocGia_Incre
on DocGia
instead of insert
as
begin
	Declare @IDDocGia  VARCHAR (5)
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='DG_ID')
    Declare @TenDocGia NVARCHAR (50)  =(select TenDocGia from inserted)
    Declare @DiaChi      NVARCHAR (100) =(select DiaChi from inserted)
    Declare @MatKhau      NVARCHAR (100) =(select MatKhau from inserted)
    Declare @SoDienThoai VARCHAR (12)   =(select SoDienThoai from inserted)
    Declare @Email       NVARCHAR (50)  =(select Email from inserted)
    Declare @CMND        VARCHAR (11)   =(select CMND from inserted)
    Declare @NgayLap      DATETIME   = GetDate()
	Declare @SoNgayHetHan int = (select GiaTri from BangRangBuoc where IDRangBuoc='DAYGH')
    Declare @NgayHetHan      DATETIME   =DateADD(dd,@SoNgayHetHan,@NgayLap)
    Declare @NgaySinh      DATETIME   =(select NgaySinh from inserted)

	set @IDDocGia='DG'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)
	insert into DocGia(IDDocGia,TenDocGia,DiaChi,SoDienThoai,Email,CMND,NgayLap,NgayHetHan,NgaySinh,TinhTrang,TongTienPhat,MatKhau) values (@IDDocGia,@TenDocGia,@DiaChi,@SoDienThoai,@Email,@CMND,@NgayLap,@NgayHetHan,@NgaySinh,0,0,@MatKhau) 
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='DG_ID'
end
go
--///////////////////////////////////////
-- Phieu Tien Phat
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('PP_ID',1,N'Gía trị tự động tăng Phieu Phat')
go
create Trigger PhieuThuTienPhat_Incre
on PhieuThuTienPhat 
instead of insert
as
begin
	Declare @IDPhieuThuTienPhat VARCHAR (5)
    Declare @IDDocGia NVARCHAR (5)  =(select IDDocGia from inserted)
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='PP_ID')
    Declare @TienThu Decimal(9,0)  =(select TienThu from inserted)

	set @IDPhieuThuTienPhat='PP'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)
	insert into PhieuThuTienPhat(IDPhieuThuTienPhat,IDDocGia,TienThu) values (@IDPhieuThuTienPhat,@IDDocGia,@TienThu)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='PP_ID'
end
go


--///////////////////////////////////////
-- Phieu Nhap Sach
--///////////////////////////////////////
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('PN_ID',1,N'Gía trị tự động tăng Phieu Nhap')
go
create Trigger PhieuNhapSach_Incre
on PhieuNhapSach
instead of insert
as
begin
	Declare @IDPhieuNhapSach VARCHAR (5)
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='PN_ID')
    Declare @IDNhanVien NVARCHAR (5)  =(select IDNhanVien from inserted)

	set @IDPhieuNhapSach='PN'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)
	insert into PhieuNhapSach(IDPhieuNhapSach,IDNhanVien,NgayNhap,TongSoLuong,TongDongia) values (@IDPhieuNhapSach,@IDNhanVien,GETDATE(),0,0)
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='PN_ID'
end
go
--///////////////////////////////////////
-- Chi Tiet Phieu Nhap Sach
--///////////////////////////////////////
create Trigger ChiTietPhieuNhapSach_insert
on ChiTietPhieuNhapSach
after insert
as
begin
	Declare @IDPhieuNhapSach VARCHAR (5) =(select IDPhieuNhapSach from inserted)
    Declare @IDSach NVARCHAR (5)  =(select IDSach from inserted)
    Declare @Soluong int  =(select SoLuong from inserted)
	Declare @DonGia Decimal(9,0) =(select DonGia from inserted)


	Update PhieuNhapSach Set TongSoLuong=TongSoLuong+@Soluong,TongDongia+=@DonGia*@Soluong where IDPhieuNhapSach=@IDPhieuNhapSach
	Update Sach Set SoLuongTon+=@Soluong,SoLuong+=@SoLuong where IDSach=@IDSach 
end
go
create Trigger ChiTietPhieuNhapSach_Update
on ChiTietPhieuNhapSach
after update
as
begin
	Declare @IDPhieuNhapSach VARCHAR (5) =(select IDPhieuNhapSach from inserted)
    Declare @IDSach NVARCHAR (5)  =(select IDSach from inserted)
    Declare @Soluong_new int  =(select SoLuong from inserted)
    Declare @Soluong_old int  =(select SoLuong from deleted)
	Declare @Soluong int  =@Soluong_new-@Soluong_old	
	Declare @DonGia_New Decimal(9,0) =(select DonGia from inserted)
	Declare @DonGia_Old Decimal(9,0) =(select DonGia from deleted)
	Declare @DonGia Decimal(9,0) = @DonGia_new-@DonGia_Old
	if(@Soluong_new=@Soluong_old)
		Update PhieuNhapSach Set TongDongia+=@Soluong_new*@DonGia where IDPhieuNhapSach=@IDPhieuNhapSach
	else if(@DonGia_New=@DonGia_Old) 
	begin
		Update PhieuNhapSach Set TongDongia+=@Soluong*@DonGia_New,TongSoLuong+=@Soluong where IDPhieuNhapSach=@IDPhieuNhapSach
		Update Sach Set SoLuongTon+=@Soluong,SoLuong+=@SoLuong where IDSach=@IDSach 
	end
	else
	begin
		Update PhieuNhapSach Set TongDongia+=@Soluong*@DonGia,TongSoLuong+=@Soluong where IDPhieuNhapSach=@IDPhieuNhapSach
		Update Sach Set SoLuongTon+=@Soluong,SoLuong+=@SoLuong where IDSach=@IDSach 
	end
end
go
create Trigger ChiTietPhieuNhapSach_Delete
on ChiTietPhieuNhapSach
after delete
as
begin
	Declare @IDPhieuNhapSach VARCHAR (5) =(select IDPhieuNhapSach from deleted)
    Declare @IDSach NVARCHAR (5)  =(select IDSach from deleted)
    Declare @Soluong int  =(select SoLuong from deleted)
	Declare @DonGia Decimal(9,0) =(select DonGia from deleted)

	Update PhieuNhapSach Set TongDongia-=@Soluong*@DonGia,TongSoLuong-=@Soluong where IDPhieuNhapSach=@IDPhieuNhapSach
	Update Sach Set SoLuongTon-=@Soluong,SoLuong-=@SoLuong where IDSach=@IDSach 
end
--///////////////////////////////////////
-- Chi Tiet Muon Tra
--///////////////////////////////////////
go
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('MT_ID',1,N'Giá trị tự động tăng CT Muon Tra')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('TC_%',110,N'Phần trăm tiền cọc với giá trị thực')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('PHAT',10000,N'Tiền Phạt trễ hạn mỗi ngầy')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('Thue',10000,N'Tiền thuê')
insert into BangRangBuoc(IDRangBuoc,GiaTri,GhiChu) values('Day_M',10,N'Số ngày cho phép mượn sách')
go
create Trigger CTMuonTra_Incre
on CTMuonTra 
instead of insert
as
begin
	Declare @STT VARCHAR (5)
	Declare @ID int = (select GiaTri from BangRangBuoc where IDRangBuoc='MT_ID')
    Declare @IDSach CHAR (5)  =(select IDSach from inserted)
    Declare @IDDocGia CHAR (5)  =(select IDDocGia from inserted)
    Declare @NgayMuon DateTime  =Getdate()
	Declare @SoNgayMuon int =(select GiaTri from BangRangBuoc where IDRangBuoc='Day_M')
    Declare @NgayTraQuyDinh DateTime  =DateAdd(dd,@SoNgayMuon,@NgayMuon)
	Declare @TinhTrangMuon int=(Select TinhTrangMuon from inserted)
	Declare @SoluongThue int=(Select SoLuongThue from inserted)
	Declare @TienThue_Tam decimal(9,0) =(select GiaTri from BangRangBuoc where IDRangBuoc='Thue')
	Declare @TienThue decimal(9,0) =@TienThue_Tam*@SoluongThue
	Declare @TriGia decimal(9,0) =(select TriGia from Sach where IDSach=@IDSach )
	Declare @PhanTramTienCoc int = (select GiaTri from BangRangBuoc where IDRangBuoc='TC_%')
	Declare @TienCoc decimal(9,0)
	Set @TienCoc=@TriGia*@SoluongThue*(@PhanTramTienCoc)/100

	set @STT='MT'+REPLICATE('0',3-LEN(@ID))+Convert(varchar(3),@ID)
	update Sach set SoLuongTon-=@SoluongThue where IDSach=@IDSach
	
	update BangRangBuoc set GiaTri=@ID+1 where IDRangBuoc='MT_ID'	
	if(@TinhTrangMuon=0)
		insert into CTMuonTra(STT,IDSach,IDDocGia,NgayMuon,TinhTrangMuon,SoLuongThue,TienThue,TriGia,TienCoc,TongTien) values (@STT,@IDSach,@IDDocGia,@NgayMuon,@TinhTrangMuon,@SoLuongThue,@TienThue,@TriGia,@TienCoc,@TienCoc+@TienThue)
	if(@TinhTrangMuon=1)
		insert into CTMuonTra(STT,IDSach,IDDocGia,NgayMuon,NgayTraQuyDinh,TinhTrangMuon,SoLuongThue,TienThue,TriGia,TienCoc,TongTien) values (@STT,@IDSach,@IDDocGia,@NgayMuon,@NgayTraQuyDinh,@TinhTrangMuon,@SoLuongThue,@TienThue,@TriGia,@TienCoc,@TienCoc+@TienThue)
end
go


create Trigger CTMuonTra_Update
on CTMuonTra 
after update
as
begin 
	Declare @TinhTrangMuon_New int=(Select TinhTrangMuon from inserted)
	Declare @TinhTrangMuon_Old int=(Select TinhTrangMuon from deleted)
    Declare @STT CHAR (5)  =(select STT from inserted)	
    Declare @IDSach CHAR (5)  =(select IDSach from inserted)	
    Declare @IDDocGia CHAR (5)  =(select IDDocGia from inserted)
	Declare @NgayTraQuyDinh DateTime = (select NgayTraQuyDinh from deleted)
	Declare @TienThue decimal(9,0) = (select TienThue from inserted)
	Declare @TriGia decimal(9,0) =(select TriGia from Sach where IDSach=@IDSach )
	Declare @SoLuongThue_new int =(select SoLuongThue from inserted)
	Declare @SoLuongThue_old int =(select SoLuongThue from deleted)
	Declare @SoLuongThue int = @SoLuongThue_new -@SoLuongThue_old
	Declare @PhanTramTienCoc int = (select GiaTri from BangRangBuoc where IDRangBuoc='TC_%')
	Declare @TienCoc decimal(9,0)
	Set @TienCoc=@TriGia*@SoLuongThue*(@PhanTramTienCoc)/100
		
	if(@TinhTrangMuon_New = 2 and @TinhTrangMuon_Old=1)
	begin
		Declare @NgayQuaHan int
		Set @NgayQuaHan=DATEDIFF(dd,@NgayTraQuyDinh,GETDATE())
		if(@NgayQuaHan < 0)
			Set @NgayQuaHan=0		
		Declare @TienPhat decimal(9,0) = (select GiaTri from BangRangBuoc where IDRangBuoc='PHAT')	

		Update CTMuonTra set NgayQuaHan=@NgayQuaHan,TienPhat=@TienPhat*@NgayQuaHan,NgayTraThucTe=GETDATE() where STT=@STT
		Update DocGia Set TongTienPhat+=@TienPhat*@NgayQuaHan where IDDocGia=@IDDocGia
		Update Sach set SoLuongTon+=@SoLuongThue_new where IDSach=@IDSach 
	end
	if(@TinhTrangMuon_New = 1 and @TinhTrangMuon_Old=1)
		update CTMuonTra set TongTien+=@TienCoc+@TienThue*@SoLuongThue,TienCoc+=@TienCoc,TriGia=@TriGia,TienThue+=@TienThue*@SoLuongThue where STT=@STT
	if(@TinhTrangMuon_New = 1 and @TinhTrangMuon_Old=0)
	begin	
		Declare @NgayMuon DateTime  =Getdate()
		Declare @SoNgayMuon int =(select GiaTri from BangRangBuoc where IDRangBuoc='Day_M')
		Set		@NgayTraQuyDinh   =DateAdd(dd,@SoNgayMuon,@NgayMuon)

		update CTMuonTra set NgayMuon=@NgayMuon,NgayTraQuyDinh=@NgayTraQuyDinh,TongTien+=@TienThue*@SoLuongThue+@TienCoc where STT=@STT
	end
end
go

create Trigger CTMuonTra_Delete
on CTMuonTra 
after delete
as
begin
    Declare @IDSach CHAR (5)  =(select IDSach from deleted)
	Declare @TinhTrangMuon int=(Select TinhTrangMuon from deleted)
	Declare @SoLuongThue int=(Select SoLuongThue from deleted)
	if(@TinhTrangMuon=0)
	Update Sach Set SoLuongTon+=@SoLuongThue where IDSach=@IDSach
end