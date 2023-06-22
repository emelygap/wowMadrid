from config import db
from models.address import Address
from models.location import Location

class Event(db.Model):
    __tablename__ = 'events'

    id = db.Column(db.String(15), primary_key=True)
    title = db.Column(db.String, nullable=False)
    description = db.Column(db.String)
    type = db.Column(db.String(150))
    free = db.Column(db.Boolean)
    price = db.Column(db.String)
    date_start = db.Column(db.Date, nullable=False)
    date_end = db.Column(db.Date, nullable=False)
    time = db.Column(db.Time)
    location_name = db.Column(db.String(150))
    address = db.Column(db.Integer, db.ForeignKey('addresses.id'))
    location = db.Column(db.Integer, db.ForeignKey('locations.id'))

    def get_address_data(self):
        address_data: Address= Address.query.get(self.address)
        return address_data.dict()
    
    def get_location_data(self):
        location_data: Location= Location.query.get(self.location)
        return location_data.dict()

    def __repr__(self):
        return f"<Event(id='{self.id}', title='{self.title}', description='{self.description}', type='{self.type}', free={self.free}, price='{self.price}', date_start='{self.date_start}', date_end='{self.date_end}', time='{self.time}', location_name='{self.location_name}', address={self.address}, location={self.location})>"
    
    def dict(self):
        return {
            'id': self.id,
            'title': self.title,
            'description': self.description,
            'type': self.type,
            'free': self.free,
            'price': self.price,
            'date_start': str(self.date_start),
            'date_end': str(self.date_end),
            'time': str(self.time),
            'location_name': self.location_name,
            'address': self.get_address_data(),
            'location': self.get_location_data()
        }