FROM python:3.10-alpine3.18

EXPOSE 5001

WORKDIR /app

COPY . .

#RUN apk update && apk add apturl
#RUN pip install --upgrade pip
RUN pip install -r requirements.txt

CMD ["python3", "app.py"]