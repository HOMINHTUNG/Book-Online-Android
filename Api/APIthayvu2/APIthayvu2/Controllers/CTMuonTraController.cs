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
    public class CTMuonTraController : ApiController
    {
        private dbthayvuapi2 db = new dbthayvuapi2();

        // GET: api/CTMuonTra
        public IQueryable<CTMuonTra> GetCTMuonTras()
        {
            return db.CTMuonTras;
        }
        public IHttpActionResult GetSachDaMuon(string id)
        {
            //id la id doc gia
            var listCTMuon = db.CTMuonTras.Where(s => s.IDDocGia == id && s.TinhTrangMuon == 2).ToList();

            List<Sach> listSach = new List<Sach>();
            for (int i = 0; i < listCTMuon.Count; i++)
            {
                Sach sach = db.Saches.Find(listCTMuon[i].IDSach);
                listSach.Add(sach);
            }

            if (listSach == null)
            {
                return NotFound();
            }

            return Ok(listSach);
        }
        public IHttpActionResult GetSachDangMuon(string id)
        {
            //id la id doc gia
            var listCTMuon = db.CTMuonTras.Where(s => s.IDDocGia == id && s.TinhTrangMuon == 1).ToList();

            List<Sach> listSach = new List<Sach>();
            for (int i = 0; i < listCTMuon.Count; i++)
            {
                Sach sach = db.Saches.Find(listCTMuon[i].IDSach);
                listSach.Add(sach);
            }

            if (listSach == null)
            {
                return NotFound();
            }

            return Ok(listSach);
        }
        public IHttpActionResult GetSachDatCoc(string id)
        {
            //id la id doc gia
            //var lam = db.CTMuonTras.Where(s => s.IDDocGia == id && s.TinhTrangMuon == 0).ToList();

            var listCTMuon = db.CTMuonTras.Where(s => s.IDDocGia == id && s.TinhTrangMuon == 0).ToList();

            List<Sach> listSach = new List<Sach>();
           for(int i=0; i < listCTMuon.Count; i++)
            {
               Sach sach = db.Saches.Find(listCTMuon[i].IDSach);
                listSach.Add(sach);
            }

            if (listSach == null)
            {
                return NotFound();
            }

            return Ok(listSach);
        }

        // GET: api/CTMuonTra/5
        [ResponseType(typeof(CTMuonTra))]
        public IHttpActionResult GetCTMuonTra(string id)
        {
            CTMuonTra cTMuonTra = db.CTMuonTras.Find(id);
            if (cTMuonTra == null)
            {
                return NotFound();
            }

            return Ok(cTMuonTra);
        }

        // PUT: api/CTMuonTra/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCTMuonTra(string id, CTMuonTra cTMuonTra)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != cTMuonTra.STT)
            {
                return BadRequest();
            }

            db.Entry(cTMuonTra).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CTMuonTraExists(id))
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

        // POST: api/CTMuonTra
        [ResponseType(typeof(CTMuonTra))]
        public IHttpActionResult PostCTMuonTra(CTMuonTra cTMuonTra)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.CTMuonTras.Add(cTMuonTra);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (CTMuonTraExists(cTMuonTra.STT))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = cTMuonTra.STT }, cTMuonTra);
        }

        // DELETE: api/CTMuonTra/5
        [ResponseType(typeof(CTMuonTra))]
        public IHttpActionResult DeleteCTMuonTra(string id)
        {
            CTMuonTra cTMuonTra = db.CTMuonTras.Find(id);
            if (cTMuonTra == null)
            {
                return NotFound();
            }

            db.CTMuonTras.Remove(cTMuonTra);
            db.SaveChanges();

            return Ok(cTMuonTra);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CTMuonTraExists(string id)
        {
            return db.CTMuonTras.Count(e => e.STT == id) > 0;
        }
    }
}