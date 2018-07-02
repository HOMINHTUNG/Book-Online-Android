namespace APIthayvu2.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("TacGia")]
    public partial class TacGia
    {
        [Key]
        [StringLength(5)]
        public string IDTacGia { get; set; }

        [StringLength(50)]
        public string TenTacGia { get; set; }
    }
}
