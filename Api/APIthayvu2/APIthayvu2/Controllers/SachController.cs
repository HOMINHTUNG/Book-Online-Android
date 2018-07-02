using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using APIthayvu2.Models;

namespace APIthayvu2.Controllers
{
    public class SachController : ApiController
    {
        private dbthayvuapi2 db = new dbthayvuapi2();

        // GET: api/Sach
        public IQueryable<Sach> GetSaches()
        {
            return db.Saches;
        }
        public IQueryable<Sach> GetSachNgayNhapTop10()
        {
            var items = db.Saches.OrderByDescending(u => u.NgayNhapSach).Take(10);
            return items;
        }
        public IQueryable<Sach> GetSachSoLanMuonTop10()
        {
            var items = db.Saches.OrderByDescending(u => u.SoLanMuon).Take(10);
            return items;
        }

        public IHttpActionResult GetSachTheLoai(string id)
        {
            var sach = db.Saches.Where(s => s.IDTheLoai == id).ToList();
            if (sach == null)
            {
                return NotFound();
            }

            return Ok(sach);
        }

        public IHttpActionResult GetSachTacGia(string id)
        {
            var sach = db.Saches.Where(s => s.IDTacGia == id).ToList();
            if (sach == null)
            {
                return NotFound();
            }

            return Ok(sach);
        }

        public IHttpActionResult GetSachNXB(string id)
        {
            var sach = db.Saches.Where(s => s.IDNhaXuatBan == id).ToList();
            if (sach == null)
            {
                return NotFound();
            }

            return Ok(sach);
        }

        // GET: api/Sach/5
        [ResponseType(typeof(Sach))]
        public IHttpActionResult GetSach(string id)
        {
            Sach sach = db.Saches.Find(id);
            if (sach == null)
            {
                return NotFound();
            }

            return Ok(sach);
        }

        // PUT: api/Sach/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSach(string id, Sach sach)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != sach.IDSach)
            {
                return BadRequest();
            }

            db.Entry(sach).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SachExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Sach
        [ResponseType(typeof(Sach))]
        public IHttpActionResult PostSach(Sach sach)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Saches.Add(sach);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (SachExists(sach.IDSach))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = sach.IDSach }, sach);
        }

        // DELETE: api/Sach/5
        [ResponseType(typeof(Sach))]
        public IHttpActionResult DeleteSach(string id)
        {
            Sach sach = db.Saches.Find(id);
            if (sach == null)
            {
                return NotFound();
            }

            db.Saches.Remove(sach);
            db.SaveChanges();

            return Ok(sach);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SachExists(string id)
        {
            return db.Saches.Count(e => e.IDSach == id) > 0;
        }
    }
}