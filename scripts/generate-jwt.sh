# Arguments
base64_secret="$1"
subject="$2"
issuer="$3"

# Function DEFs
base64UrlEncode() {
    echo -n "$1" | openssl enc -base64 -A | sed 's/=*$//' | sed 's/\+/-/g' | sed 's/\//_/g'
}

# JWT header
jwt_header='{"typ":"JWT","alg":"HS512"}'
encodedHeader=$(base64UrlEncode "$jwt_header")

# Payload
current_time=$(date +%s)
expiration_time=$((current_time+3600))
payload='{"iss":"'${issuer}'","iat":'${current_time}',"nbf":'${current_time}',"exp":'${expiration_time}',"sub":"'${subject}'"}'
encodedPayload=$(base64UrlEncode "$payload")

# Secret
secret=$(echo -n "${base64_secret}" | base64 -d)

# Create JWT
signature=$(echo -n "$encodedHeader.$encodedPayload" | openssl dgst -sha512 -hmac "$secret" -binary | openssl enc -base64 -A | sed 's/=*$//' | sed 's/\+/-/g' | sed 's/\//_/g')
jwt="$encodedHeader.$encodedPayload.$signature"
echo "$jwt"