from config import app
from api.event_api import event_route
from api.district_api import district_route

app.register_blueprint(event_route)
app.register_blueprint(district_route)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)