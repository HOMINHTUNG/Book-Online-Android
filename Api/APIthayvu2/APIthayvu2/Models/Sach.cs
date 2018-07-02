namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Sach")]
    public partial class Sach
    {
        [Key]
        [StringLength(5)]
        public string IDSach { get; set; }

        [Required]
        [StringLength(5)]
        public string IDTheLoai { get; set; }

        [StringLength(5)]
        public string IDTacGia { get; set; }

        [StringLength(5)]
        public string IDNhaXuatBan { get; set; }

        [Required]
        [StringLength(50)]
        public string TenSach { get; set; }

        [StringLength(200)]
        public string HinhAnh { get; set; }

        public int? NamXuatBan { get; set; }

        public int? SoLuong { get; set; }

        public int? SoLuongTon { get; set; }

        public decimal? TriGia { get; set; }

        public int? SoLanMuon { get; set; }

        public DateTime? NgayNhapSach { get; set; }

        public string MoTa { get; set; }
    }
}
