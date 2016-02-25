'e-mail' {
    from user
    to 'someone@somewhere.com'
    subject 'Orders'
    body (style: defaultStyle ? 'html' : bodyStyle) {
        p 'Attack at dawn.'
    }
}