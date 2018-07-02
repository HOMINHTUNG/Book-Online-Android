namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("BangRangBuoc")]
    public partial class BangRangBuoc
    {
        [Key]
        [StringLength(5)]
        public string IDRangBuoc { get; set; }

        public int? GiaTri { get; set; }

        [Column(TypeName = "date")]
        public DateTime? NgayHieuLuc { get; set; }

        [StringLength(100)]
        public string GhiChu { get; set; }
    }
}
