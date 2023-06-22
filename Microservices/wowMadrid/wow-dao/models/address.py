from config import db
from models.area import Area
from models.district import District

class Address(db.Model):
    __tablename__ = 'addresses'
    
    id = db.Column(db.Integer, primary_key=True)
    area= db.Column(db.Integer, db.ForeignKey('areas.id'))
    district = db.Column(db.Integer, db.ForeignKey('districts.id'))

    events = db.relationship("Event", backref='address_events', lazy='joined')

    def get_area_data(self):
        area_data: Area= Area.query.get(self.area)
        return area_data.dict()
    
    def get_district_data(self):
        district_data: District= District.query.get(self.district)
        return district_data.dict()

    def __repr__(self):
        return f"<Address(id={self.id}, area_id='{self.area_id}', district_id='{self.district_id}')>"
    
    def dict(self):
        return {
            'id': self.id,
            'area': self.get_area_data(),
            'district': self.get_district_data()
        }