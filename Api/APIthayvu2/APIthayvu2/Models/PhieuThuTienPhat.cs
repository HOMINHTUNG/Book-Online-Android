namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("PhieuThuTienPhat")]
    public partial class PhieuThuTienPhat
    {
        [Key]
        [StringLength(5)]
        public string IDPhieuThuTienPhat { get; set; }

        [Required]
        [StringLength(5)]
        public string IDDocGia { get; set; }

        [Column(TypeName = "date")]
        public DateTime? NgayThang { get; set; }

        public decimal? TienThu { get; set; }
    }
}
