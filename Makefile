all: gen/pedestal_grpc/addressbook.cljc

clean:
	rm -rf gen
	lein clean

gen/pedestal_grpc/addressbook.cljc:
	mkdir -p gen
	protoc --clojure_out=grpc-server:gen --proto_path=dev/resources dev/resources/addressbook.proto

