namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("NhanVien")]
    public partial class NhanVien
    {
        [Key]
        [StringLength(5)]
        public string IDNhanVien { get; set; }

        [Required]
        [StringLength(5)]
        public string IDChucVu { get; set; }

        [StringLength(50)]
        public string TenNhanVien { get; set; }

        public int? GioiTinh { get; set; }

        [StringLength(100)]
        public string DiaChi { get; set; }

        [StringLength(12)]
        public string SoDienThoai { get; set; }

        [StringLength(50)]
        public string Email { get; set; }

        [StringLength(11)]
        public string CMND { get; set; }

        [Column(TypeName = "date")]
        public DateTime? NgayVaoLam { get; set; }

        [StringLength(100)]
        public string MatKhau { get; set; }
    }
}
